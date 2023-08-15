package Exercise_06;
import java.util.Scanner;

public class Exercise_06_37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();
        scanner.close();
        String formattedNumber = format(number, width);
        System.out.println("Formatted number: " + formattedNumber);
    }
    
    public static String format(int number, int width) {
        String numberString = String.valueOf(number);
        int diff = width - numberString.length();
        
        if (diff <= 0) {
            return numberString;
        } else {
            StringBuilder formattedNumber = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                formattedNumber.append("0");
            }
            formattedNumber.append(numberString);
            return formattedNumber.toString();
        }
    }
}
