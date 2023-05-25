import React, { useEffect, useState } from "react";
import { useRouter } from "next/router";
import styles from "../styles/Gallery.module.css";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const YourCatsGallery = () => {
  const [images, setImages] = useState([]);
  const [showAddCatForm, setShowAddCatForm] = useState(false);
  const [catDetails, setCatDetails] = useState({
    name: "",
    breed: "",
    description: "",
    photo: null,
  });
  const [selectedImage, setSelectedImage] = useState(null);

  async function postCat(catDetails) {
    const token = localStorage.getItem("authToken"); // Assumes you have saved your token in local storage
    const url = "http://localhost:5432/cats"; // Change this to your actual API endpoint

    console.log("token", token);
    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify(catDetails),
      });

      if (response.ok) {
        const jsonResponse = await response.json();
        toast.success("Your cat was submitted successfully!", {
          position: toast.POSITION.TOP_CENTER,
        });
        return jsonResponse;
      } else {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
    } catch (error) {
      toast.error(`An error occurred: ${error.message}`, {
        position: toast.POSITION.TOP_CENTER,
      });
    }
  }
  async function getDetails() {
    const token = localStorage.getItem("authToken"); // Assumes you have saved your token in local storage
    const url = "http://localhost:5432/cats"; // Change this to your actual API endpoint

    try {
      const response = await fetch(url, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });
      if (response.ok) {
        const jsonResponse = await response.json();
        const catDetails = await Promise.all(
          jsonResponse.map(async (id) => {
            const photoResponse = await fetch(url + `/${id}`, {
              method: "GET",
              headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
              },
            });

            return await photoResponse.json();
          })
        );

        setImages(catDetails); // Set images state here
      } else {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
    } catch (error) {
      toast.error(`An error occurred: ${error.message}`, {
        position: toast.POSITION.TOP_CENTER,
      });
    }
  }
  useEffect(() => {
    getDetails();
  }, []);

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

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    setShowAddCatForm(false);

    const reader = new FileReader();
    reader.readAsDataURL(catDetails.photo);

    await new Promise((resolve) => {
      reader.onloadend = resolve;
    });

    const formData = new FormData();
    formData.append("image", catDetails.photo);

    try {
      const response = await fetch("http://127.0.0.1:8000/predict", {
        method: "POST",
        body: formData,
      });

      if (!response.ok) {
        // Add a condition for a 400 status code
        if (response.status === 400) {
          console.log("There are no cats in the photo");
          toast.error("There are no cats in the photo", {
            position: toast.POSITION.TOP_CENTER,
          });
        } else {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        setCatDetails({ name: "", breed: "", description: "", photo: null });
        return; // Make sure we stop here if the response was not ok
      }

      const prediction = await response.json();

      const isCat = prediction.some(
        (pred) => pred.cat.toLowerCase() === "true"
      );

      if (isCat) {
        const base64Image = reader.result;
        let cutData = base64Image.replace("data:image/jpeg;base64,", "");
        const catData = {
          name: catDetails.name,
          breed: catDetails.breed,
          description: catDetails.description,
          image: cutData,
        };
        console.log(catData);
        toast.success("Your photo was submitted successfully!", {
          position: toast.POSITION.TOP_CENTER,
        });
        const catResponse = await postCat(catData);
        const howManyCats = await getDetails();
        console.log("How many cats", howManyCats);

        if (catResponse) {
          getDetails();
        }
      } else {
        toast.error("The image is not a cat!", {
          position: toast.POSITION.TOP_CENTER,
        });
      }
    } catch (error) {
      toast.error("An error occurred!", {
        position: toast.POSITION.TOP_CENTER,
      });
    }

    setCatDetails({ name: "", breed: "", description: "", photo: null });
  };

  async function handleDeleteImage(event, imageId) {
    // prevent the click event from triggering the handleImageClick function
    event.stopPropagation();

    // Add your API endpoint
    const url = `http://localhost:5432/cats/${imageId}`;

    const token = localStorage.getItem("authToken");

    try {
      const response = await fetch(url, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      // After the item is deleted from the database, remove it from the state
      setImages((prevImages) =>
        prevImages.filter((image) => image.id !== imageId)
      );
      toast.success("The cat image was deleted successfully!", {
        position: toast.POSITION.TOP_CENTER,
      });
    } catch (error) {
      toast.error(`An error occurred: ${error.message}`, {
        position: toast.POSITION.TOP_CENTER,
      });
    }
  }

  const handleImageClick = (image) => {
    setSelectedImage(image);
  };

  const handleCloseModal = () => {
    setSelectedImage(null);
  };

  return (
    <div className={styles.container}>
      <ToastContainer />
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
              Description:
              <input
                className={styles.formInput}
                type="text"
                name="description"
                onChange={handleFormChange}
                value={catDetails.description}
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
              <img
                src={`data:image/jpeg;base64,${image.image}`}
                alt={image.name}
              />

              <div className={styles.photoDetails}>
                <h3>NAME: {image.name}</h3>
                <h3>BREED: {image.breed}</h3>
                <h3>DESCRIPTION: {image.description}</h3>
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
            <img
              src={`data:image/jpeg;base64,${selectedImage.image}`}
              alt="Selected Cat"
            />
            <div className={styles.selectedImageDetails}>
              <h3>NAME: {selectedImage.name}</h3>
              <h3>BREED: {selectedImage.breed}</h3>
              <h3>DESCRIPTION: {selectedImage.description}</h3>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default YourCatsGallery;
