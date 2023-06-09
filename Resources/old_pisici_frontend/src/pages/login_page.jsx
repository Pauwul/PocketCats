"use client";
import React, { useState } from "react";
import { useRouter } from "next/navigation";
import styles from "../design_css/LoginPage.module.css";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import LoginForm from "../components/LoginForm";
import RootLayout from '../app/layout';


const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const router = useRouter();

  const isEmailValid = (email) => {
    const emailRegex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
    return emailRegex.test(email);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!isEmailValid(email)) {
      toast.error("Invalid email format");
      return;
    } else if (password.length === 0) {
      toast.error("Please enter your password");
      return;
    } else if (password.length <= 6) {
      toast.error("Your password must be at least 6 characters long");
      return;
    } else {
      // Here we can check if the email and the password are correct according to DB.
      router.push("/page_after_login");
    }
  };

  return (
    <div className={styles.container}>
      <div className={styles.contentWrapper}>
        <h1 className={styles.title2}>PocketCats</h1>
        <LoginForm
          email={email}
          password={password}
          onEmailChange={(e) => setEmail(e.target.value)}
          onPasswordChange={(e) => setPassword(e.target.value)}
          onSubmit={handleSubmit}
        />
      </div>
      <ToastContainer />
    </div>
  );
};

export default LoginPage;
