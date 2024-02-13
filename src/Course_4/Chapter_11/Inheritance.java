package Course_4.Chapter_11;
import java.util.Scanner;
import Course_4.Chapter_13.Triangle;

public class Inheritance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3: ");
        double side3 = input.nextDouble();
        System.out.print("Enter a color: ");
        String color = input.next();
        System.out.print("Is the triangle filled? (y/n): ");
        boolean filled = input.next().charAt(0) == 'y';
        Triangle triangle = new Triangle(side1, side2, side3, color, filled);
        System.out.println(triangle.toString());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
        input.close();
    }
}