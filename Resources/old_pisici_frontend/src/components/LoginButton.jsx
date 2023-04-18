import React from "react";
import styles from "../design_css/LoginPage.module.css";

const LoginButton = ({ onClick }) => (
  <button type="submit" className={styles.submitButton} onClick={onClick}>
    Login
  </button>
);

export default LoginButton;
