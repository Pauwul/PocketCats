import Head from 'next/head'
import Layout from '../components/layout';
import ToDoList from '../components/todo-list';
import LoginPage from '../components/LoginPage';
import withAuth from '../components/withAuth';

function Home() {
  return (
    <div>
      <Head>
        <title>Full Stack Book To Do</title>
        <meta name="description" content="Full Stack Book To Do" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
    </div>
  )
}

export default withAuth(Home);