import React from "react";
import styles from "../styles/LoginPage_old.module.css";

const LoginButton = ({ onClick }) => (
  <button type="submit" className={styles.submitButton} onClick={onClick}>
    Login
  </button>
);

export default LoginButton;
