package com.example.catSpringBoot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.catSpringBoot.security.TokenAuthenticationFilter;
import com.example.catSpringBoot.security.oauth2.OAuth2AuthenticationSuccessHandler;
import com.example.catSpringBoot.service.CustomOAuth2UserService;

@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    OAuth2AuthenticationSuccessHandler successHandler;

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

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
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()
                .successHandler(successHandler);
        // .successHandler(successHandler);
        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
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