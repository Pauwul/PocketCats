import styles from "../styles/Home_old.module.css";
import withAuth from "../components/withAuth";
function Leaderboard() {
  return (
    <>
      <div>
        <h1>This is leaderboard page</h1>
        <p>Here you can see top catlovers in your town</p>
      </div>

      <div className={styles.grid}>
        <a href="/page_after_login" className={styles.card}>
          <h2>Home Page</h2>
        </a>
      </div>
    </>
  );
}

export default withAuth(Leaderboard);
