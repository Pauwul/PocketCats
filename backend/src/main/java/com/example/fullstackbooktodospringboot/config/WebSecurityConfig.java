package com.example.fullstackbooktodospringboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.fullstackbooktodospringboot.auth.OAuth2AuthenticationSuccessHandler;
import com.example.fullstackbooktodospringboot.auth.TokenAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    OAuth2AuthenticationSuccessHandler successHandler;

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // ...
        http.cors().and()// Enable CORS support
                .csrf().disable() // Disable CSRF protection for simplicity (enable if needed)
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .oauth2Login()
                .successHandler(successHandler);
        // .successHandler(successHandler);
        return http.build();
    }

    // @Bean
    // public CorsConfigurationSource corsConfigurationSource() {
    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // CorsConfiguration corsConfiguration = new CorsConfiguration();
    // corsConfiguration.addAllowedOrigin("localhost:3000");
    // corsConfiguration.addAllowedMethod("*");
    // corsConfiguration.addAllowedHeader("*");
    // corsConfiguration.setAllowCredentials(true);

    // source.registerCorsConfiguration("/**", corsConfiguration);
    // return source;
    // }
    // @Bean
    // public CorsFilter corsFilter() {
    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // CorsConfiguration corsConfiguration = new CorsConfiguration();
    // corsConfiguration.addAllowedOrigin("localhost:3000");
    // corsConfiguration.addAllowedMethod("*");
    // corsConfiguration.addAllowedHeader("*");
    // corsConfiguration.setAllowCredentials(true);

    // source.registerCorsConfiguration("/**", corsConfiguration);
    // return new CorsFilter(source);
    // }

    // @Bean
    // public CorsConfigurationSource corsConfigurationSource() {
    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // CorsConfiguration corsConfiguration = new CorsConfiguration();
    // corsConfiguration.addAllowedOrigin("localhost:3000");
    // corsConfiguration.addAllowedMethod("*");
    // corsConfiguration.addAllowedHeader("*");
    // corsConfiguration.setAllowCredentials(true);

    // source.registerCorsConfiguration("/**", corsConfiguration);
    // return source;
    // }

}