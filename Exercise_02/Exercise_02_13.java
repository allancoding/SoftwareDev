package Exercise_02;
import java.util.Scanner;

public class Exercise_02_13 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter monthly saving amount: $");
        double saving = input.nextDouble();
        input.close();
        int month = 6;
        double account = 0.0;
        for (int i = 0; i < month; i++) {
            account = (saving + account) * (1.0 + 0.00417);
        }
        System.out.println("After the sixth month, the account value is $" + account);
    }
}