// package com.example.fullstackbooktodospringboot.config;

// import java.util.Collections;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.http.HttpStatus;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.security.web.authentication.HttpStatusEntryPoint;
// import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import
// com.example.fullstackbooktodospringboot.auth.OAuth2AuthenticationSuccessHandler;
// import
// com.example.fullstackbooktodospringboot.auth.TokenAuthenticationFilter;

// @SpringBootApplication
// @RestController
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

// @RequestMapping("/user")
// public Map<String, Object> user(@AuthenticationPrincipal OAuth2User
// principal) {
// return Collections.singletonMap("name", principal.getAttribute("name"));
// }

// @Autowired
// OAuth2AuthenticationSuccessHandler successHandler;

// @Bean
// public TokenAuthenticationFilter tokenAuthenticationFilter() {
// return new TokenAuthenticationFilter();
// }

// @Override
// protected void configure(HttpSecurity http) throws Exception {
// 		// @formatter:off
// 		http
// 		.cors().and() // Enable CORS support
//             .csrf().disable() // Disable CSRF protection for simplicity (enable if needed)
//             .authorizeRequests()
//                 .antMatchers("/").permitAll()
//                 .anyRequest().authenticated()
//                 .and()
//             .exceptionHandling()
//                 .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                 .and()
//                 .oauth2Login()
//                     .successHandler(successHandler);

// 		// .cors().and()
// 		// 	.authorizeRequests(a -> a
// 		// 	.antMatchers("/").permitAll()
// 		// 		.anyRequest().authenticated()
// 		// 	)
// 		// 	.exceptionHandling(e -> e
// 		// 		.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
// 		// 	)
// 		// 	.csrf(c -> c
// 		// 		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
// 		// 	)
// 		// 	.logout(l -> l
// 		// 		.logoutSuccessUrl("/").permitAll()
// 		// 	)
// 		// 	.oauth2Login()
// 		// 	.successHandler(successHandler);
// 		// @formatter:on
// }
// }
