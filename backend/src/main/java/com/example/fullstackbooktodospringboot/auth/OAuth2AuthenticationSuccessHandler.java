package com.example.fullstackbooktodospringboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private TokenProvider tokenProvider;

    @Autowired
    public OAuth2AuthenticationSuccessHandler(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

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
