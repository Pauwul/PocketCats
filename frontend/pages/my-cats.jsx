import React, { useState } from "react";
import { useRouter } from "next/router";
import styles from "../styles/Gallery.module.css";

const YourCatsGallery = () => {
  const [images, setImages] = useState([]);
  const [showAddCatForm, setShowAddCatForm] = useState(false);
  const [catDetails, setCatDetails] = useState({
    name: "",
    breed: "",
    photo: null,
  });
  const [selectedImage, setSelectedImage] = useState(null);
  const router = useRouter();
  const [idCounter, setIdCounter] = useState(1); // Counter for assigning IDs

  const handleFileChange = (e) => {
    if (e.target.files.length) {
      setCatDetails((prevState) => ({
        ...prevState,
        photo: e.target.files[0],
      }));
    }
  };

  const handleAddImage = () => {
    setShowAddCatForm(true);
  };

  const handleCloseForm = () => {
    setShowAddCatForm(false);
  };

  const handleFormChange = (e) => {
    setCatDetails({ ...catDetails, [e.target.name]: e.target.value });
  };

  const handleFormSubmit = (e) => {
    e.preventDefault();
    setShowAddCatForm(false);

    const reader = new FileReader();
    reader.readAsDataURL(catDetails.photo);
    reader.onloadend = () => {
      setImages((prevImages) => [
        ...prevImages,
        {
          id: idCounter, // Assign a unique ID to each image
          image: reader.result,
          name: catDetails.name,
          breed: catDetails.breed,
        },
      ]);
      setIdCounter((prevCounter) => prevCounter + 1); // Increment the counter
    };

    setCatDetails({ name: "", breed: "", photo: null });
  };

  const handleDeleteImage = (event, id) => {
    event.stopPropagation(); // Stop the event from bubbling up
    setImages((prevImages) => prevImages.filter((image) => image.id !== id));
  };

  const handleImageClick = (image) => {
    setSelectedImage(image);
  };

  const handleCloseModal = () => {
    setSelectedImage(null);
  };

  return (
    <div className={styles.container}>
      <div className={styles.titleContainer}>
        <h1 className={styles.title}>Your Cats Gallery</h1>
        <button className={styles.addButton} onClick={handleAddImage}>
          Add Image
        </button>
      </div>
      {showAddCatForm && (
        <div className={styles.modal}>
          <form className={styles.form} onSubmit={handleFormSubmit}>
            <button className={styles.closeButton} onClick={handleCloseForm}>
              Close
            </button>
            <label className={styles.formLabel}>
              Name:
              <input
                className={styles.formInput}
                type="text"
                name="name"
                onChange={handleFormChange}
                value={catDetails.name}
                required
              />
            </label>
            <label className={styles.formLabel}>
              Breed:
              <input
                className={styles.formInput}
                type="text"
                name="breed"
                onChange={handleFormChange}
                value={catDetails.breed}
                required
              />
            </label>
            <label className={styles.formLabel}>
              Photo:
              <div className={styles.fileUploadContainer}>
                <input
                  className={styles.fileUploadInput}
                  type="file"
                  name="photo"
                  onChange={handleFileChange}
                  id="fileUpload"
                  required
                />
                <label className={styles.fileUploadButton} htmlFor="fileUpload">
                  {catDetails.photo ? catDetails.photo.name : "Choose file"}
                </label>
              </div>
            </label>
            <div className={styles.formButtonsContainer}>
              <button className={styles.formSubmitButton} type="submit">
                Submit
              </button>
            </div>
          </form>
        </div>
      )}
      <div className={styles.photoContainer}>
        {images.map((image) => (
          <div
            key={image.id}
            className={styles.photoCard}
            onClick={() => handleImageClick(image)}
          >
            <div className={styles.photo}>
              <img src={image.image} alt={image.name} />
              <div className={styles.photoDetails}>
                <h3>NAME: {image.name}</h3>
                <h3>BREED: {image.breed}</h3>
                <button
                  className={styles.deleteButton}
                  onClick={(event) => handleDeleteImage(event, image.id)}
                >
                  Delete
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
      {selectedImage && (
        <div className={styles.modalOverlay} onClick={handleCloseModal}>
          <div className={styles.modalContent}>
            <img src={selectedImage.image} alt="Selected Cat" />
            <div className={styles.selectedImageDetails}>
              <h3>NAME: {selectedImage.name}</h3>
              <h3>BREED: {selectedImage.breed}</h3>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default YourCatsGallery;
