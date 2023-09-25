package Course_2.Exercise_06;
import java.util.Scanner;

/**
 * <h1>Exercise 6-37</h1>
 * <p>This is used to format a given number with a given width</p>
 * 
 * <p>Created: 9/25/2023</p>
 * <p>Modified: 9/25/2023</p>
 * 
 * @author Allan Niles
 */
public class Exercise_06_37 {
    
    /** 
     * This is the main method (entry point) that gets called by the JVM
     * 
     * @param args
     */
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
    
    /** 
     * This method formats the given number with the given width
     * 
     * <pre>Examples:
     * {@code format(34, 4) returns "0034"
     * format(34, 2) returns "34"
     * format(34, 1) returns "34"}</pre>
     * 
     * @param number The number to be formatted
     * @param width The width of the formatted number
     * @return String The formatted number
     */
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
