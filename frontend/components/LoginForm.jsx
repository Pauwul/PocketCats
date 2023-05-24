import React from "react";
import EmailInput from "./EmailInput";
import PasswordInput from "./PasswordInput";
import LoginButton from "./LoginButton";
import styles from "../styles/LoginPage_old.module.css";

const LoginForm = ({
  email,
  password,
  onEmailChange,
  onPasswordChange,
  onSubmit,
}) => {
  const handleLogin = () => {
    window.location.href = "http://localhost:5432/oauth2/authorization/github";
  };

  return (
    <form onSubmit={onSubmit} className={styles.form}>
      <h1 className={styles.title}>Login</h1>
      <EmailInput value={email} onChange={onEmailChange} />
      <PasswordInput value={password} onChange={onPasswordChange} />
      <LoginButton onClick={onSubmit} />
      <div>
        <button
          type="button"
          className={styles.submitButton}
          onClick={handleLogin}
        >
          Login with Github
        </button>
      </div>
    </form>
  );
};

export default LoginForm;
