package Course_4.Chapter_06;
import java.util.Scanner;

public class Exercise_06_19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the 3 sides of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        if (isValid(side1, side2, side3)) {
            System.out.println("Side 1: " + side1);
            System.out.println("Side 2: " + side2);
            System.out.println("Side 3: " + side3);
            System.out.println("Area: " + area(side1, side2, side3));
        } else {
            System.out.println("That is not a valid triangle.");
        }
        input.close();
    }
    public static boolean isValid(double side1, double side2, double side3) {
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1){
            return true;
        }
        return false;
    }

    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }
}
