import Head from "next/head";
import FrontPage from "../pages/page_old";

export default function Home() {
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
