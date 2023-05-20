package com.example.fullstackbooktodospringboot.service;

import java.util.Optional;

import org.apache.tomcat.util.digester.SystemPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.fullstackbooktodospringboot.model.User;
import com.example.fullstackbooktodospringboot.repository.UserRepository;
import com.example.fullstackbooktodospringboot.security.UserPrincipal;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private static final Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        String username = String.valueOf((Integer) oAuth2User.getAttribute("id"));
        // System.out.println("Username in user service: " + username);
        if (!StringUtils.hasLength(username)) {
            // throw new OAuth2AuthenticationProcessingException("Username not found from
            // OAuth2 provider");
            System.out.println("Username not found from OAuth2 provider");
        }
        // logger.info("OAuth2User attributes: {}", oAuth2User.getAttributes());
        // System.out.println("Username in user service: " + username);
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user = updateExistingUser(user, oAuth2User);
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2User);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        User user = new User();

        // user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        // user.setProviderId(oAuth2UserInfo.getId());
        user.setName(oAuth2User.getName());
        // System.out.println("Registered: " + oAuth2User.getName());
        return userRepository.save(user);
    }

    private User updateExistingUser(User existingUser, OAuth2User oAuth2User) {
        existingUser.setName(oAuth2User.getName());
        // System.out.println("Updated: " + oAuth2User.getName());
        return userRepository.save(existingUser);
    }
}
