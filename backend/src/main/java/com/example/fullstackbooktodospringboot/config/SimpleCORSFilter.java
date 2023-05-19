// package com.example.fullstackbooktodospringboot.config;

// import java.io.IOException;
// import javax.servlet.Filter;
// import javax.servlet.FilterChain;
// import javax.servlet.FilterConfig;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
// import javax.servlet.annotation.WebFilter;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;
// import org.springframework.core.Ordered;

// @Component
// @Order(Ordered.HIGHEST_PRECEDENCE)
// @WebFilter("/*")
// public class SimpleCORSFilter implements Filter {

// private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

// public SimpleCORSFilter() {
// log.info("SimpleCORSFilter init");
// }

// @Override
// public void doFilter(ServletRequest req, ServletResponse res, FilterChain
// chain)
// throws IOException, ServletException {
// // log.info("SimpleCORSFilter is filtering...");
// HttpServletRequest request = (HttpServletRequest) req;
// HttpServletResponse response = (HttpServletResponse) res;

// response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
// response.setHeader("Access-Control-Allow-Credentials", "true");
// response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,
// DELETE");
// response.setHeader("Access-Control-Max-Age", "3600");
// response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept,
// X-Requested-With, remember-me");
// // Handle the preflight OPTIONS request
// if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
// response.setStatus(HttpServletResponse.SC_OK);
// } else {
// chain.doFilter(request, response);
// log.info("SimpleCORSFilter is filtering...");
// }
// // log.info("SimpleCORSFilter is filtering...");
// }

// @Override
// public void init(FilterConfig filterConfig) {
// }

// @Override
// public void destroy() {
// }

// }