import React from "react";
import styles from "../design_css/LoginPage.module.css";

const EmailInput = ({ value, onChange }) => (
  <div className={styles.inputGroup}>
    <label htmlFor="email" className={styles.label}>
      Email
    </label>
    <input
      type="email"
      id="email"
      value={value}
      onChange={onChange}
      className={styles.input}
      required
    />
  </div>
);

export default EmailInput;
