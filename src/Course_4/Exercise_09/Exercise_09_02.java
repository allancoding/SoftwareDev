package Course_4.Exercise_09;

class Rectangle {
    double width = 1;
    double height = 1;
    Rectangle() {}
    Rectangle(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }
    double getArea() {
        return width * height;
    }
    double getPerimeter() {
        return 2 * (width + height);
    }
}
