package com.example.catSpringBoot.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

import com.example.catSpringBoot.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

@Component
public class TokenProvider {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String createToken(Authentication authentication) {
        String username = ((UserPrincipal) authentication.getPrincipal()).getUsername();
        Date now = new Date();
        System.out.println("Username in token: " + username);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 3600000)) // 1 hour
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (SecurityException e) {
            System.err.println("Invalid JWT signature.");
        } catch (MalformedJwtException e) {
            System.err.println("Invalid JWT token.");
        } catch (ExpiredJwtException e) {
            System.err.println("Expired JWT token.");
        } catch (UnsupportedJwtException e) {
            System.err.println("Unsupported JWT token.");
        } catch (IllegalArgumentException e) {
            System.err.println("JWT token compact of handler are invalid.");
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
