package Course_2.Exercise_05;
import java.util.Scanner;
import java.util.ArrayList;

public class Exercise_05_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive or negative number: ");
        ArrayList<Double> numbers = new ArrayList<Double>();
        numbers.add(input.nextDouble());
        Boolean go = true;
        int number = 1;
        while (go == true) {
            System.out.print("Enter a positive or negative number: (0 to quit): ");
            numbers.add(input.nextDouble());
            if (numbers.get(number) == 0) {
                go = false;
                numbers.remove(number);
            }
            number++;
        }
        input.close();
        int pos = 0;
        int neg = 0;
        double total = 0;
        double ave = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
                pos = pos +1;
            } else if (numbers.get(i) < 0) {
                neg = neg +1;
            }
            total = total + numbers.get(i).intValue();
            ave = total / numbers.size();
        }
        System.out.println("Positive numbers: " +pos);
        System.out.println("Negative numbers: " +neg);
        System.out.println("The total is " +total);
        System.out.println("The average is " +ave);
    }
}