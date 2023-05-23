package com.example.fullstackbooktodospringboot.security.oauth2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;

import com.example.fullstackbooktodospringboot.security.TokenProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class OAuth2AuthenticationSuccessHandlerTest {

    @Mock
    private TokenProvider tokenProvider;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private Authentication authentication;

    @Mock
    private RedirectStrategy redirectStrategy;

    @InjectMocks
    private OAuth2AuthenticationSuccessHandler successHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        successHandler.setRedirectStrategy(redirectStrategy);
    }

    @Test
    public void testOnAuthenticationSuccess() throws IOException {
        String token = "valid-token";
        String redirectUrl = "http://localhost:3000/login-success?token=" + token;
        when(tokenProvider.createToken(authentication)).thenReturn(token);

        successHandler.onAuthenticationSuccess(request, response, authentication);

        verify(tokenProvider).createToken(authentication);
        verify(redirectStrategy).sendRedirect(request, response, redirectUrl);
    }
}
