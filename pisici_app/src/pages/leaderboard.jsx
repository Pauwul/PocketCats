import styles from '../design_css/Home.module.css';

function Leaderboard() {
    return (
      <>
      <div>
        <h1>This is leaderboard page</h1>
        <p>Here you can see top catlovers in your town</p>
      </div>

      <div className={styles.grid}>
      <a href="/" className={styles.card}>
            <h2>Home Page</h2>
          </a>
      </div>

      </>
    );
  }
  
  
  export default Leaderboard;