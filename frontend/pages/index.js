
import FrontPage from "../pages/page_old";
import Head from 'next/head';

function Home() {
  return (
    <>
      <Head>
        <title>PocketCats</title>
        <meta name="description" content="Full Stack Book To Do" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      {/* <Layout> */}
      {/* <ToDoList /> */}
      {/* </Layout> */}
      <FrontPage />
    </>
  );
}

export default Home;
