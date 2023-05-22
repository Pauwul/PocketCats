import Head from "next/head";
import styles from "../styles/Home_old.module.css";
import React from "react";
//import Profile from '../components/Profile'
import ToDoList from "./todo-list";
import withAuth from "../components/withAuth";
import { ToastContainer } from "react-toastify";

function page_after_login() {
  return (
    <div className={styles.container}>
      <Head>
        <title>PocketCats</title>
        <meta
          name="description"
          content="PocketCats - Find and photograph cats in your area"
        />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main className={styles.main}>
        <h1 className={styles.title}>
          Welcome to <a href="#">PocketCats!</a>
        </h1>

        <p className={styles.description}>
          Find and photograph cats in your area
        </p>

        <div className={styles.grid}>
          <ToastContainer />
          <a href="/how-it-works" className={styles.card}>
            <h2>How it Works &rarr;</h2>
            <p>
              Learn how to use PocketCats to find and photograph cats in your
              neighborhood.
            </p>
          </a>

          <a href="/my-cats" className={styles.card}>
            <h2>My Cats &rarr;</h2>
            <p>View and manage the cats you've photographed and updated.</p>
          </a>

          <a href="/leaderboard" className={styles.card}>
            <h2>Leaderboard &rarr;</h2>
            <p>See the top PocketCats photographers in your area.</p>
          </a>

          <a href="/todo-list" className={styles.card}>
            <h2>Blog &rarr;</h2>
            <p>See the blog of PocketCats photographers in your area.</p>
          </a>
        </div>
      </main>
    </div>
  );
}

export default withAuth(page_after_login);
