import React from "react";
import styles from "../styles/LoginPage_old.module.css";

const PasswordInput = ({ value, onChange }) => (
  <div className={styles.inputGroup}>
    <label htmlFor="password" className={styles.label}>
      Password
    </label>
    <input
      type="password"
      id="password"
      value={value}
      onChange={onChange}
      className={styles.input}
      required
    />
  </div>
);

export default PasswordInput;
