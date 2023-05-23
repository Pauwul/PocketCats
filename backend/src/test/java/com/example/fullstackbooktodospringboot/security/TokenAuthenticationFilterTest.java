package com.example.fullstackbooktodospringboot.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TokenAuthenticationFilterTest {
    @Mock
    private TokenProvider tokenProvider;

    @InjectMocks
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoFilterInternal_ValidToken() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        FilterChain filterChain = Mockito.mock(FilterChain.class);

        String token = "valid-token";
        String username = "john.doe@example.com";

        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(tokenProvider.validateToken(token)).thenReturn(true);
        when(tokenProvider.getUsernameFromToken(token)).thenReturn(username);

        tokenAuthenticationFilter.doFilterInternal(request, response, filterChain);

        verify(request).getHeader("Authorization");
        verify(tokenProvider).validateToken(token);
        verify(tokenProvider).getUsernameFromToken(token);
        verify(filterChain).doFilter(any(), any());
        verify(request, Mockito.never()).setAttribute(Mockito.anyString(), Mockito.any());
        verify(request, Mockito.never()).removeAttribute(Mockito.anyString());
    }

    @Test
    public void testDoFilterInternal_InvalidToken() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        FilterChain filterChain = Mockito.mock(FilterChain.class);

        String token = "invalid-token";

        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(tokenProvider.validateToken(token)).thenReturn(false);

        tokenAuthenticationFilter.doFilterInternal(request, response, filterChain);

        verify(request).getHeader("Authorization");
        verify(tokenProvider).validateToken(token);
        verify(tokenProvider, Mockito.never()).getUsernameFromToken(token);
        verify(filterChain).doFilter(any(), any());
        verify(request, Mockito.never()).setAttribute(Mockito.anyString(), Mockito.any());
        verify(request, Mockito.never()).removeAttribute(Mockito.anyString());
    }

    @Test
    public void testDoFilterInternal_NoToken() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        FilterChain filterChain = Mockito.mock(FilterChain.class);

        when(request.getHeader("Authorization")).thenReturn(null);

        tokenAuthenticationFilter.doFilterInternal(request, response, filterChain);

        verify(request).getHeader("Authorization");
        verify(tokenProvider, Mockito.never()).validateToken(Mockito.anyString());
        verify(tokenProvider, Mockito.never()).getUsernameFromToken(Mockito.anyString());
        verify(filterChain).doFilter(any(), any());
        verify(request, Mockito.never()).setAttribute(Mockito.anyString(), Mockito.any());
        verify(request, Mockito.never()).removeAttribute(Mockito.anyString());
    }
}
