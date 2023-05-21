import React, { useState } from "react";
import { useRouter } from "next/router";
import styles from "../styles/Gallery.module.css";

const YourCatsGallery = () => {
  const [images, setImages] = useState([]);
  const [showAddCatForm, setShowAddCatForm] = useState(false);
  const [catDetails, setCatDetails] = useState({
    name: "",
    breed: "",
    photo: "",
  });
  const router = useRouter();

  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileChange = (e) => {
    if (e.target.files.length) {
      setCatDetails((prevState) => ({
        ...prevState,
        photo: e.target.files[0],
      }));
      setSelectedFile(e.target.files[0].name);
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
    // TODO: handle the form submission
    setShowAddCatForm(false);
  };

  return (
    <div className={styles.gallery}>
      <h1 className={styles.title}>Your Cats Gallery</h1>
      <button className={styles.addButton} onClick={handleAddImage}>
        Add Image
      </button>
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
                  {selectedFile ? selectedFile : "Choose file"}
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
      <div className={styles.imageContainer}>
        {images.map((image, index) => (
          <div key={index} className={styles.imageCard}>
            <img className={styles.image} src={image} alt="Cat" />
          </div>
        ))}
      </div>
    </div>
  );
};

export default YourCatsGallery;
