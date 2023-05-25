package com.example.catSpringBoot.service;
// package com.example.fullstackbooktodospringboot.service;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.security.core.AuthenticationException;
// import
// org.springframework.security.oauth2.client.registration.ClientRegistration;
// import
// org.springframework.security.oauth2.client.registration.ClientRegistration.ProviderDetails;
// import
// org.springframework.security.oauth2.client.registration.ClientRegistration.ProviderDetails.UserInfoEndpoint;
// import
// org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.core.OAuth2AccessToken;
// import
// org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import com.example.fullstackbooktodospringboot.model.User;
// import com.example.fullstackbooktodospringboot.repository.UserRepository;
// import com.example.fullstackbooktodospringboot.security.UserPrincipal;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// import java.util.HashMap;
// import java.util.Map;
// import java.util.Optional;

// public class CustomOAuth2UserServiceTest {

// @Mock
// private UserRepository userRepository;

// @InjectMocks
// private CustomOAuth2UserService customOAuth2UserService;

// @BeforeEach
// public void setup() {
// MockitoAnnotations.openMocks(this);
// }

// @Test
// public void testLoadUser_ExistingUser() {
// OAuth2UserRequest oAuth2UserRequest = mock(OAuth2UserRequest.class);
// OAuth2User oAuth2User = mock(OAuth2User.class);
// User existingUser = new User();
// existingUser.setName("john.doe");

// when(oAuth2User.getAttribute("id")).thenReturn(123);
// when(oAuth2UserRequest.getClientRegistration().getRegistrationId()).thenReturn("registrationId");
// when(userRepository.findByUsername("123")).thenReturn(Optional.of(existingUser));
// when(userRepository.save(existingUser)).thenReturn(existingUser);

// OAuth2User result = customOAuth2UserService.loadUser(oAuth2UserRequest);

// assertNotNull(result);
// assertTrue(result instanceof UserPrincipal);
// // assertEquals(existingUser, userRepository.findByUsername("123"));

// verify(userRepository).findByUsername("123");
// verify(userRepository).save(existingUser);
// }

// @Test
// public void testLoadUser_NewUser() {
// OAuth2UserRequest oAuth2UserRequest = mock(OAuth2UserRequest.class);
// OAuth2User oAuth2User = mock(OAuth2User.class);
// User newUser = new User();
// newUser.setName("123");

// // Create mock objects for intermediate dependencies
// ClientRegistration clientRegistration = mock(ClientRegistration.class);
// ProviderDetails providerDetails = mock(ProviderDetails.class);
// UserInfoEndpoint userInfoEndpoint = mock(UserInfoEndpoint.class);

// when(oAuth2User.getAttribute("id")).thenReturn(123);
// when(oAuth2UserRequest.getClientRegistration().getRegistrationId()).thenReturn("registrationId");
// when(userRepository.findByUsername("123")).thenReturn(Optional.empty());
// when(userRepository.save(any(User.class))).thenReturn(newUser);

// OAuth2User result = customOAuth2UserService.loadUser(oAuth2UserRequest);

// assertNotNull(result);
// assertTrue(result instanceof UserPrincipal);
// // assertEquals(newUser, ((UserPrincipal) result).getUser());

// verify(userRepository).findByUsername("123");
// verify(userRepository).save(any(User.class));
// }

// @Test
// public void testLoadUser_UsernameNotFound() {
// DefaultOAuth2UserService defaultOAuth2UserService =
// mock(DefaultOAuth2UserService.class);
// OAuth2UserRequest oAuth2UserRequest = mock(OAuth2UserRequest.class);
// OAuth2User oAuth2User = mock(OAuth2User.class);
// OAuth2AccessToken oAuth2AccessToken = mock(OAuth2AccessToken.class);
// // Create mock objects for intermediate dependencies
// ClientRegistration clientRegistration = mock(ClientRegistration.class);
// ProviderDetails providerDetails = mock(ProviderDetails.class);
// UserInfoEndpoint userInfoEndpoint = mock(UserInfoEndpoint.class);
// // bypass the flow
// when(oAuth2User.getAttribute("id")).thenReturn("ss");
// when(oAuth2UserRequest.getClientRegistration()).thenReturn(clientRegistration);
// when(clientRegistration.getProviderDetails()).thenReturn(providerDetails);
// when(providerDetails.getUserInfoEndpoint()).thenReturn(userInfoEndpoint);
// when(oAuth2UserRequest.getAccessToken()).thenReturn(oAuth2AccessToken);
// when(oAuth2AccessToken.getTokenValue()).thenReturn("some token");
// when(userInfoEndpoint.getUserNameAttributeName()).thenReturn("some name");
// when(userInfoEndpoint.getUri()).thenReturn("localhost:5432/");
// // when(defaultOAuth2UserService.)

// assertThrows(NullPointerException.class, () -> {
// customOAuth2UserService.loadUser(oAuth2UserRequest);
// });

// verify(userRepository, never()).findByUsername(anyString());
// verify(userRepository, never()).save(any(User.class));
// }
// }
