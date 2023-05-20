import React from "react";
import { useRouter } from "next/router";

const UpdateCatPage = () => {
  const router = useRouter();
  const { catId } = router.query;

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission to update the cat in the DB
    router.push(`/cats/${catId}`);
  };

  return (
    <div>
      <h1>Update Cat {catId}</h1>
      <form onSubmit={handleSubmit}>
        {/* Add your form fields here */}
        <button type="submit">Update Cat</button>
      </form>
    </div>
  );
};

export default UpdateCatPage;
