package com.example.catSpringBoot.service;

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

import com.example.catSpringBoot.model.User;
import com.example.catSpringBoot.repository.UserRepository;
import com.example.catSpringBoot.security.UserPrincipal;

/**
 * The custom oauth2 user service, this service is used to load the user from
 * the oauth2 provider and save it to the database
 */
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    /**
     * The user repository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Load the user from the oauth2 provider
     * 
     * @param oAuth2UserRequest the oauth2 user request
     * @return OAuth2User the oauth2 user
     * @throws OAuth2AuthenticationException
     */
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

    /**
     * Process the oauth2 user, save the user to the database if it does not exist
     * and if
     * the user exists update the user
     * 
     * @param oAuth2UserRequest the oauth2 user request
     * @param oAuth2User        the oauth2 user
     * @return OAuth2User
     */
    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        String username = String.valueOf((Integer) oAuth2User.getAttribute("id"));
        System.out.println("Username in user service: " + username);
        if (!StringUtils.hasLength(username)) {
            throw new OAuth2AuthenticationException("Username not found from OAuth2 provider");
        }
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

    /**
     * Register a new user
     * 
     * @param oAuth2UserRequest the oauth2 user request
     * @param oAuth2User        the oauth2 user
     * @return User the saved user
     */
    private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        User user = new User();
        user.setName(oAuth2User.getName());
        return userRepository.save(user);
    }

    /**
     * Update an existing user
     * 
     * @param existingUser the existing user
     * @param oAuth2User   the oauth2 user
     * @return User the updated user
     */
    private User updateExistingUser(User existingUser, OAuth2User oAuth2User) {
        existingUser.setName(oAuth2User.getName());
        // System.out.println("Updated: " + oAuth2User.getName());
        return userRepository.save(existingUser);
    }
}
