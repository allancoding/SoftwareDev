package Course_2.Exercise_04;
import java.util.Scanner;
import java.lang.Math;

public class Exercise_04_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the prompted information for a regular polygon.");
        System.out.print("Enter the number of sides: ");
        Integer sides = input.nextInt();
        System.out.print("Enter the length of sides: ");
        Double length = input.nextDouble();
        input.close();
        double area = (sides*Math.pow(length, 2))/(4*Math.tan(Math.PI/sides));
        System.out.println("The area of the regular polygon is: "+area);
    }
}