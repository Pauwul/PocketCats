package com.example.catSpringBoot.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.catSpringBoot.security.TokenProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handle the OAuth2 authentication success
 */
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    /**
     * The token provider
     */
    private TokenProvider tokenProvider;

    /**
     * Constructor for the OAuth2 authentication success handler
     * 
     * @param tokenProvider the token provider
     */
    @Autowired
    public OAuth2AuthenticationSuccessHandler(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    /**
     * Handle the OAuth2 authentication success
     * 
     * @param request        the request
     * @param response       the response
     * @param authentication the authentication
     * @throws IOException the exception
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        String token = tokenProvider.createToken(authentication);
        // response.getWriter().write(token);
        String redirectUrl = "http://localhost:3000/login-success?token=" + token;
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
        // System.out.println("Token: " + token);
    }
}
