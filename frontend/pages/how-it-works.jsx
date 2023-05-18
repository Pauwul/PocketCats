import styles from '../styles/Home_old.module.css';


function HowItWorks() {
  return (
    <>
      <div>
        <h1>This is how_it_works2 page</h1>
        <p>Here you're gonna learn how a ll features that can be used in PocketCats </p>
      </div>
      <div className={styles.grid}>
      <a href="/" className={styles.card}>
            <h2>Home Page</h2>
          </a>
      </div>
    </>
  );
}

export default HowItWorks;