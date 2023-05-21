import requests
import sys

url = 'http://127.0.0.1:8000/predict'

# sys.argv[0] is the script name, sys.argv[1] is the first argument
file_path = sys.argv[1]

with open(file_path, 'rb') as img:
    file_dict = {
        'image': (file_path, img, 'image/jpeg')
    }
    response = requests.post(url, files=file_dict)

print(response.json())
