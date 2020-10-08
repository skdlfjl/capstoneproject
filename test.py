import cv2, sys
from matplotlib import pyplot as plt
import numpy as np

image = cv2.imread('timetable.jpg')
image_gray = cv2.imread('timetable.jpg',cv2.IMREAD_GRAYSCALE)

b, g, r = cv2.split(image)
image2 = cv2.merge([r, g, b])
#RGB모두 있는 사진
plt.imshow(image2)
plt.show()

#새로운 창 뜸
#cv2.imshow('image',image)
#흑백사진
#cv2.imshow('image_gray',image_gray)

cv2.waitKey(0)
cv2.destroyAllWindows()

blur = cv2.blur(image_gray, ksize=(1,1))

#blur = cv2.GaussianBlur(image_gray, ksize=(1,1), sigmaX=0)
#이게 가장 그럴법함
ret, thresh1 = cv2.threshold(blur, 127, 255, cv2.THRESH_BINARY)
edged = cv2.Canny(blur, 10, 250)
cv2.imshow('Edged', edged)
cv2.waitKey(0)

#글씨가 뭉개짐
kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (7,7))
closed = cv2.morphologyEx(edged, cv2.MORPH_CLOSE, kernel)
cv2.imshow('closed', closed)
cv2.waitKey(0)

#자료구조 하나만 인식을 못한다;;
contours, _ = cv2.findContours(closed.copy(),cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
total = 0
contours_image = cv2.drawContours(image, contours, -1, (0,255,0), 3)
cv2.imshow('contours_image', contours_image)
cv2.waitKey(0)
cv2.destroyAllWindows()

