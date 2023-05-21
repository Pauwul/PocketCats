import json
import io 
def test_predict(app, client):
    # Replace with the ID of an existing image in your API
    image_path = 'tests/test_image.jpg'
    with open(image_path, 'rb') as image_file:
       data = {
            'image': (image_file, image_path)
        }
    response = client.post('/predict', data=data)
    
    assert response.status_code == 200
    # Add any additional assertions to test the response content or behavior
