package Course_2.Chapter_05;
import java.util.Scanner;

public class Exercise_05_30 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter monthly saving amount: $");
        double saving = input.nextDouble();
        System.out.print("Enter number of months of savings: ");
        int month = input.nextInt();
        System.out.print("Enter annual interest rate withoput percent symbol (ex. 4% = 4): ");
        double rate = input.nextDouble();
        input.close();
        double account = 0.0;
        double interest = rate/100;
        interest = interest/12; 
        for (int i = 0; i < month; i++) {
            account = (saving + account) * (1 + interest);
        }
        System.out.println("After the month "+month+", the account value is $" + account);
    }
}