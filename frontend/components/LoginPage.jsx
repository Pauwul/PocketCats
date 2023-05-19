import React from 'react';
import axios from 'axios';
import { useRouter } from 'next/router';

// export default function LoginPage() {
//   const router = useRouter();

//   const handleLogin = async () => {
//     try {
//       const response = await axios.get('http://localhost:5432/oauth2/authorization/github');
//       const { token } = response.data;

//       // Save the token in local storage.
//       localStorage.setItem('token', token);

//       // Redirect the user to the home page.
//       router.push('/');
//     } catch (error) {
//       console.error('Login failed:', error);
//     }
//   };

//   return (
//     <div>
//       <button onClick={handleLogin}>Login with Github</button>
//     </div>
//   );
// }

const LoginPage = () => {
    const handleLogin = async () => {
        // Redirect the user to start the OAuth2 flow
        window.location.href = 'http://localhost:5432/oauth2/authorization/github';
    };

    return (
        <div>
            <button onClick={handleLogin}>Login with Github</button>
        </div>
    );
};

export default LoginPage;
