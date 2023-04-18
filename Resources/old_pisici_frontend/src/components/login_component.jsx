



const login_component = () => {

     // Get the router instance for programmatic navigation
  const router = useRouter();

  const isEmailValid = (email) => {
    const emailRegex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
    return emailRegex.test(email);
  };

  // Function to handle form submission
const handleSubmit = (e) => {
  // Prevent the default form submission behavior
  e.preventDefault();

  // Check if email is valid
  if (!isEmailValid(email)) {
    toast.error("Invalid email formasgasgasgsat");
    return;
  }

    return (
        <div className={styles.container}>
            <div className={styles.contentWrapper}>
                {/* Display the application title */}
                <h1 className={styles.title2}>PocketCats</h1>

                {/* Form to handle email and password input */}
                <form onSubmit={handleSubmit} className={styles.form}>
                    {/* Display the login form title */}
                    <h1 className={styles.title}>Login</h1>

                    {/* Display error message if it exists */}
                    {errorMessage && (
                        <div className={styles.error}>
                            {errorMessage}
                        </div>
                    )}

                    {/* Input group for email */}
                    <div className={styles.inputGroup}>
                        {/* Label for the email input */}
                        <label htmlFor="email" className={styles.label}>
                            Email
                        </label>
                        {/* Email input field */}
                        <input
                            type="email"
                            id="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            className={styles.input}
                            required
                        />
                    </div>

                    {/* Input group for password */}
                    <div className={styles.inputGroup}>
                        {/* Label for the password input */}
                        <label htmlFor="password" className={styles.label}>
                            Password
                        </label>
                        {/* Password input field */}
                        <input
                            type="password"
                            id="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            className={styles.input}
                            required
                        />
                    </div>

                    {/* Login button */}
                    <button
                        type="submit"
                        className={styles.submitButton}
                        onClick={handleSubmit}
                    >
                        Login
                    </button>
                </form>
            </div>
            {/* Add the ToastContainer to display the toast notifications */}
            <ToastContainer />
        </div>
    );
};