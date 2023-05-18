import React from "react";

const AddCatPage = () => {
  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission to add a cat to the DB
    const { name, breed, description } = e.target.elements;

    const catData = {
      name: name.value,
      breed: breed.value,
      description: description.value,
    };

    // You can now send the catData object to your backend or perform any other necessary operations

    // Reset the form
    e.target.reset();
  };

  return (
    <div>
      <h1>Add Cat</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input type="text" id="name" name="name" required />
        </div>
        <div>
          <label htmlFor="breed">Breed:</label>
          <input type="text" id="breed" name="breed" required />
        </div>
        <div>
          <label htmlFor="description">Description:</label>
          <textarea id="description" name="description" required></textarea>
        </div>
        <button type="submit">Add Cat</button>
      </form>
    </div>
  );
};

export default AddCatPage;
