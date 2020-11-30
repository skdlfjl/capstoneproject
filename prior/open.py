import cv2 as cv



cap = cv.VideoCapture(0)


while(True):

    ret, img_color = cap.read()

    if ret == False:
        continue;

    cv.imshow('bgr', img_color)

    # ESC 키누르면 종료
    if cv.waitKey(1) & 0xFF == 27:
        break


cap.release()
cv.destroyAllWindows()