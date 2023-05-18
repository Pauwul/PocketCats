import React from "react";
import EmailInput from "./EmailInput";
import PasswordInput from "./PasswordInput";
import LoginButton from "./LoginButton";
import styles from "../styles/LoginPage_old.module.css";

const LoginForm = ({ email, password, onEmailChange, onPasswordChange, onSubmit }) => (
  <form onSubmit={onSubmit} className={styles.form}>
    <h1 className={styles.title}>Login</h1>
    <EmailInput value={email} onChange={onEmailChange} />
    <PasswordInput value={password} onChange={onPasswordChange} />
    <LoginButton onClick={onSubmit} />
  </form>
);

export default LoginForm;
