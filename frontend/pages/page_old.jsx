"use client";
import React from "react";
import styles from "../styles/FrontPage_old.module.css";
import Link from "next/link";

const FrontPage = () => {
  return (
    <div className={styles.container}>
      <div className={styles.topMenu}>
        <Link href="/login_page">
          <button className={styles.menuButton}>Sign In</button>
        </Link>
        <button className={styles.menuButton}>Register</button>
        <button className={styles.menuButton}>FAQ</button>
      </div>
      <div className={styles.titleContainer}>
        <h1 className={styles.title}>Pocket Cats</h1>
        <p className={styles.subtitle}>
          Collect your friend's cats and vote for the best one!
          <br />
          Like pokemon. But more wholesome.
        </p>
      </div>
      <div className={styles.footer}></div>
    </div>
  );
};

export default FrontPage;
