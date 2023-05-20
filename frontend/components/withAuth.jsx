import { useRouter } from 'next/router';
import { useEffect } from 'react';

const withAuth = (WrappedComponent) => {
  return (props) => {
    const router = useRouter();

    useEffect(() => {
      const fetchData = async () => {
        try {
          const token = localStorage.getItem('authToken');
          //const response = await fetch('localhost:5432/', {
          //   headers: {
          //     Authorization: `Bearer ${token}`,
          //   },
          // });
      
          if (response.status === 401|| token === null) {
            // Redirect to the login page
            router.push('/login');
          }
          else {
            // Handle successful response and proceed with rendering the wrapped component
            //router.push('/');
          }
          console.log("response");
        } catch (error) {
          // Handle error response
          console.log(error);
        }
      };
      

      fetchData();
    }, [router]);

    return <WrappedComponent {...props} />;
  };
};

export default withAuth;