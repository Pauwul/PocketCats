from tensorflow.keras.applications.vgg16 import VGG16
import os
import numpy as np
import cv2

# importing the image and model 
model = VGG16(weights='imagenet')

img = cv2.imread('cat3.jpeg')

# preprocessing
img = cv2.resize(img,(224,224))

img = img.astype('float32') / 255.0

preds = model.predict(img[np.newaxis, ...])



cat_prob = preds[0,0]
if cat_prob > 0.5:
	print('this a cat uwu')
else:
	print('this is not a cat.')

