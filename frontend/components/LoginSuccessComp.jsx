import { useEffect } from "react";
import { useRouter } from "next/router";

const LoginSuccessComp = () => {
  const router = useRouter();
  const { token } = router.query;

  useEffect(() => {
    if (token) {
      // Save the token to localStorage
      localStorage.setItem("authToken", token);

      // Redirect to the dashboard or any other page
      router.push("/page_after_login");
    }
  }, [token]);

  return <div>Redirecting...</div>;
};

export default LoginSuccessComp;
