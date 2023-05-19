// package com.example.fullstackbooktodospringboot.auth;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

// @RestController
// public class AuthController {

// private static final String CLIENT_ID = "af39404ec65880c471ce";
// private static final String REDIRECT_URI =
// "http://localhost:5432/login/oauth2/code/github";

// @GetMapping("/auth/github")
// public void redirectToGithub(HttpServletResponse response) throws IOException
// {
// System.out.println("Redirecting to Github...");
// response.sendRedirect(
// "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID +
// "&redirect_uri=" + REDIRECT_URI);
// System.out.println("Redirected to Github!");
// }

// @GetMapping("/login/oauth2/code/github")
// public String handleGithubCallback(String code) {
// // Here you would exchange the code for an access token and authenticate the
// // user
// System.out.println("Authorization code: " + code);

// // ...

// return "Logged in!";
// }
// }
