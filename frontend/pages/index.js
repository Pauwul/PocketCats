import Head from 'next/head';
import Layout from '../components/layout';
import ToDoList from '../components/todo-list';
import withAuth from '../components/withAuth';
import axios from 'axios';

function Home() {

  const fetchData = async () => {
      try {
          const token = localStorage.getItem('authToken');
          const response = await axios.get('http://localhost:5432/todos', {
              headers: {
                  Authorization: `Bearer ${token}`,
              },
          });
  
          // Process the response data
          console.log(response.data);
      } catch (error) {
          // Handle error
          console.error(error);
      }
  };
  

  return (
    <div>
      <Head>
        <title>Full Stack Book To Do</title>
        <meta name="description" content="Full Stack Book To Do" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Layout>
        <h1>Welcome to the Home Page</h1>
        {/* <ToDoList /> */}

        <button onClick={fetchData}>Get todos</button>
      </Layout>
    </div>
  );
}

export default withAuth(Home);
