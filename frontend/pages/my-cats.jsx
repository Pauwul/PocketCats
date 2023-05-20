import styles from '../styles/Home_old.module.css';
import withAuth from '../components/withAuth';

function MyCats() {
  return (
    <>
    <div>
      <h1>This is MyCats page</h1>
      <p>Here is your PocketCats gallery</p>
    </div>
    <div className={styles.grid}>
      <a href="/" className={styles.card}>
            <h2>Home Page</h2>
          </a>
      </div>
    
    </>
  );
}

export default withAuth(MyCats);
