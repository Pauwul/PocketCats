import React from "react";

const CatsPage = () => {
  // Replace this with your actual cat data
  const cats = [
    {
      id: 1,
      name: "Whiskers",
      breed: "Persian",
      description: "A fluffy and friendly cat.",
    },
    // Add more cat objects as needed
  ];

  return (
    <div>
      <h1>Cats</h1>
      {cats.map((cat) => (
        <div key={cat.id}>
          <img src={cat.photoUrl} alt={cat.name} />
          <h2>{cat.name}</h2>
          <p>Breed: {cat.breed}</p>
          <p>Description: {cat.description}</p>
        </div>
      ))}
    </div>
  );
};

export default CatsPage;
