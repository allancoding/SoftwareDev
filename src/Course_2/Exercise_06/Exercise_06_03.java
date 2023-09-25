package Course_2.Exercise_06;
import java.util.Scanner;

/**
* <h1>Exercise 6-3</h1>
* <p>This is used to check if a given number is a palindrome</p>
*
* <p>Created: 9/25/2023</p>
* <p>Modified: 9/25/2023</p>
*
* @author Allan Niles
*/
public class Exercise_06_03 {
    
    /** 
     * This method reverses the given number
     * 
     * <pre>Examples:
     * {@code reverse(123) returns 321
     * reverse(1234) returns 4321
     * reverse(1) returns 1}</pre>
     * }<pre>
     * 
     * @param number The number to be reversed
     * @return int The reversed number
     */
    public static int reverse(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return reversedNumber;
    }
    
    /** 
     * This method checks if the given number is a palindrome
     * 
     * <pre>Examples:
     * {@code isPalindrome(123) returns false
     * isPalindrome(12321) returns true
     * isPalindrome(1) returns true
     * }<pre>
     * 
     * @param number The number to be checked
     * @return boolean True if the number is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    
    /** 
     * This is the main method (entry point) that gets called by the JVM
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int input = scanner.nextInt();
        scanner.close();
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }
}
