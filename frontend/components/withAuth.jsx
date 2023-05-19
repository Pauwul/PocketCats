import { useRouter } from 'next/router';
import { useEffect } from 'react';

const withAuth = (WrappedComponent) => {
    return (props) => {
        const Router = useRouter();

        useEffect(() => {
            const token = localStorage.getItem('authToken');

            if (!token) {
                Router.replace('/login');
            }
        }, [Router]);

        return <WrappedComponent {...props} />;
    };
};

export default withAuth;

