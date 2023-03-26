import styles from '../design_css/Home.module.css';

function HowItWorks() {
  return (
    <div style={{ fontFamily: 'Roboto, sans-serif' }}>
      <h1>This is how_it_works page</h1>
      <p>Here you're gonna learn how all features that can be used in PocketCats </p>
    </div>
  );
}

function HowItWorks2() {
  return (
    <>
      <HowItWorks />
      <div>
        <h1>This is how_it_works2 page</h1>
        <p>Here you're gonna learn how all features that can be used in PocketCats </p>
      </div>
      <div className={styles.grid}>
      <a href="/" className={styles.card}>
            <h2>Home Page</h2>
          </a>
      </div>
    </>
  );
}

export default HowItWorks2;