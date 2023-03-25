import Head from 'next/head';
import styles from '../design_css/Home.module.css';
import React from 'react';
import PocketCats from '../components/PocketCats.jsx';

export default function Home() {
  return (
    <div className={styles.container}>
      <Head>
        <title>PocketCats</title>
        <meta name="description" content="PocketCats - Find and photograph cats in your area" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <PocketCats />

      <main className={styles.main}>
        <h1 className={styles.title}>
          Welcome to <a href="#">PocketCats!</a>
        </h1>

        <p className={styles.description}>
          Find and photograph cats in your area
        </p>

        <div className={styles.grid}>
          <a href="#" className={styles.card}>
            <h2>How it Works &rarr;</h2>
            <p>Learn how to use PocketCats to find and photograph cats in your neighborhood.</p>
          </a>

          <a href="#" className={styles.card}>
            <h2>My Cats &rarr;</h2>
            <p>View and manage the cats you've photographed and updated.</p>
          </a>

          <a href="#" className={styles.card}>
            <h2>Leaderboard &rarr;</h2>
            <p>See the top PocketCats photographers in your area.</p>
          </a>
        </div>
      </main>

      <footer className={styles.footer}>
        <a
          href="https://www.example.com"
          target="_blank"
          rel="noopener noreferrer"
        >
          Created by Your Name
        </a>
      </footer>
    </div>
  );
}
