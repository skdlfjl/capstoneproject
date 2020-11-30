import cv2
from matplotlib import pyplot as plt

image = cv2.imread('C:/Users/jimin/PycharmProjects/capstoneproject/practice/timetable_black.png')
imgray = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)
ret,thresh = cv2.threshold(imgray,127,255,0)
imgray, contours= cv2.findContours(thresh,cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)


img = cv2.drawContours(imgray, contours, 3, (0,255,0), 3)

plt.imshow(img)
