// components/CallbackPage.js
import React, { useEffect } from 'react';
import { useLocation, useHistory } from 'react-router-dom';
import { exchangeAuthorizationCode } from '../pages/api/api';

const CallbackPage = ({ authOptions }) => {
  const location = useLocation();
  const history = useHistory();

  useEffect(() => {
    const code = new URLSearchParams(location.search).get('code');

    if (code) {
      exchangeAuthorizationCode(authOptions, code)
        .then((response) => {
          // Store the access token in the state or cookie
          const accessToken = response.access_token;
          // Redirect to a protected route or main app page
          history.push('/');
        })
        .catch((error) => {
          // Handle the error
          console.error('Error exchanging authorization code:', error);
        });
    }
  }, [location.search, history]);

  return <div>Logging in...</div>;
};

export default CallbackPage;
