from keras.applications.vgg16 import VGG16
from tensorflow.keras.preprocessing import image
from tensorflow.keras.applications.vgg16 import preprocess_input,decode_predictions
from flask import Flask, request, jsonify
from keras.preprocessing.image import img_to_array
from keras.applications.vgg16 import preprocess_input
from PIL import Image


model = VGG16(weights='imagenet')
print(model.summary())
app = Flask(__name__)
@app.route('/predict', methods=['POST'])
def predict():
    # Load the image from the request
    # img = load_img(request.files['image'], target_size=(224, 224))

    # Load the image from the request
    img = Image.open(request.files['image'])
    img = img.resize((224, 224))
    # Preprocess the image
    img_array = img_to_array(img)
    img_array = preprocess_input(img_array)
    img_array = img_array.reshape(1, 224, 224, 3)

    # Make the prediction
    prediction = model.predict(img_array)

    # Return the result
    # if prediction[0][0][2] > 0.3 and (prediction[0][0][1] == 'tabby' or prediction[0][0][1] == 'tiger_cat' or prediction[0][0][1] == 'Egyptian_cat' ) :
    print(prediction[0][0] )
    if prediction[0][0] > 0.3 and (prediction[0][1] == 'tabby' or prediction[0][1] == 'tiger_cat' or prediction[0][1] == 'Egyptian_cat'):
        return jsonify({'result': 'Not a cat'})
    else:
        return jsonify({'result': 'Cat'})

if __name__ == '__main__':
    app.run(port=8000)
