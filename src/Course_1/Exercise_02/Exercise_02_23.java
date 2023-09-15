package Course_1.Exercise_02;
import java.util.Scanner;

public class Exercise_02_23 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the driving distance: ");
        double distance = input.nextDouble();
        System.out.print("Enter miles per gallon: ");
        double milespergallon = input.nextDouble();
        System.out.print("Enter price per gallon: ");
        double pricepergallon = input.nextDouble();
        input.close();
        double gallon = distance/milespergallon;
        double price = pricepergallon*gallon;
        String cost = String.format("%.2f", price);
        System.out.println("The cost of driving is $" + cost);
    }
}