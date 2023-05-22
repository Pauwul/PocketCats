from keras.applications.vgg16 import VGG16
from tensorflow.keras.preprocessing import image
from tensorflow.keras.applications.vgg16 import preprocess_input,decode_predictions
from flask import Flask, request, jsonify
from tensorflow.keras.preprocessing.image import img_to_array
from keras.applications.vgg16 import preprocess_input
from PIL import Image
from flasgger import Swagger
from flask_cors import CORS, cross_origin


model = VGG16(weights='imagenet')
print(model.summary())
app = Flask(__name__)
swagger = Swagger(app)
# Create a CORS object
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'

@app.route('/predict', methods=['POST'])
@cross_origin()
def predict():
    """
    Determine if an image contains a cat or not
    ---
    tags:
      - images
    parameters:
      - name: image
        in: body
        type: file
        required: true
        description: the image to use cat detector on
    responses:
      200:
        description: The output values
        schema:
            id: prediction
            properties:
                breed:
                    type: string
                    description: The breed of the cat, if it's not a cat, it may return something else, like a dog breed or other animal
                    default: tabby
                cat:
                    type: boolean
                    description: Cat || Not a cat
                    default: false
                probability:
                    type: float
                    description: The probability of the prediction
                    default: 0.0
      404:
        description: Invalid input
      500:
        description: Error
    """
    # Load the image from the request
    img = Image.open(request.files['image'])
    img = img.resize((224, 224))
    # Preprocess the image
    img_array = img_to_array(img)
    img_array = preprocess_input(img_array)
    img_array = img_array.reshape(1, 224, 224, 3)

    prediction = model.predict(img_array)
    p = decode_predictions(prediction)



    array = []
    for i in range(3):
        breed = p[0][i][1]
        if  breed in ['tabby', 'tiger_cat', 'Egyptian_cat']:
            isCat = True
        else:
            isCat = False
        probability = p[0][i][2]
        array.append({'breed': f'{breed}', 'probability': f'{probability}', 'cat': f'{isCat}'})
    # return each element as a json object
    return jsonify(array)




if __name__ == '__main__':
    app.run(port=8000)
