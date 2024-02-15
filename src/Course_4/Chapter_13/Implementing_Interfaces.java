package Course_4.Chapter_13;

public class Implementing_Interfaces {
    public static void main(String[] args) {
        GeometricObject[] triangles = {new Triangle(), new Triangle(), new Triangle(), new Triangle(), new Triangle()};
        for (int i = 0; i < triangles.length; i++) {
            System.out.println("Triangle " + (i + 1) + ":");
            System.out.println("Area: " + triangles[i].getArea());
            triangles[i].howToColor();
        }
    }
}
