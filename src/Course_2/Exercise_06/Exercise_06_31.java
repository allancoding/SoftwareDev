package Course_2.Exercise_06;
import java.util.Scanner;

/**
* <h1>Exercise 6-31</h1>
* 
* <p>This is used to check if a given credit card number is valid</p>
* <p>Credit card numbers follow certain patterns. A credit card number must have between 13 and 16 digits. It must start with:
* <br>■	4 for Visa cards 
* <br>■	5 for Master cards 
* <br>■	37 for American Express cards 
* <br>■	6 for Discover cards
* <br>In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers. The algorithm is useful to determine whether a card number is entered correctly or whether a credit card is scanned correctly by a scanner. Credit card numbers are generated following this validity check, commonly known as the Luhn check or the Mod 10 check, which can be described as follows (for illustra- tion, consider the card number 4388576018402626):
* <br>
* <br>1. Double every second digit from right to left. If doubling of a digit results in a two-digit number, add up the two digits to get a single-digit number.
* <br>2. Now add all single-digit numbers from Step 1. 4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
* <br>3. Add all digits in the odd places from right to left in the card number. 6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
* <br>4. Sum the results from Step 2 and Step 3. 37 + 38 = 75
* <br>5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is invalid. For example, the number 4388576018402626 is invalid, but the number 4388576018410707 is valid.
*
* <p>Created: 9/25/2023</p>
* <p>Modified: 9/25/2023</p>
*
* @author Allan Niles
*/
public class Exercise_06_31 {
  
  /** 
   * This method checks if the given credit card number is valid and it is main method called by the JVM
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a credit card number as a long integer: ");
    long number = input.nextLong();
    input.close();

    if (isValid(number))
      System.out.println(number + " is valid");
    else
      System.out.println(number + " is invalid"); 
  }

  /**
   * This method checks if the given credit card number is valid
   * 
   * <pre>Examples:
   * {@code
   * isValid(4388576018410707) returns true
   * isValid(4388576018402626) returns false
   * isValid(438857601840262) returns false
   * }<pre>
   * 
   * @param number The credit card number to be checked
   * @return boolean True if the number is valid, false otherwise
   */
  public static boolean isValid(long number) {
    return  (getSize(number) >= 13) && (getSize(number) <= 16) && 
        (prefixMatched(number, 4) || prefixMatched(number, 5) ||
        prefixMatched(number, 6) || prefixMatched(number, 37)) && 
       (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
  }

  /** 
   * This method returns the sum of the digits in the even places of the given number
   * 
   * <pre>Examples:
   * {@code
   * sumOfDoubleEvenPlace(4388576018402626) returns 37
   * sumOfDoubleEvenPlace(4388576018410707) returns 38
   * }<pre>
   * 
   * @param number The number to be checked
   * @return int The sum of the digits in the even places of the given number
   */
  public static int sumOfDoubleEvenPlace(long number) {
    int result = 0;
    
    number = number / 10; // Starting from the second digit from left
    while (number != 0) {
      result += getDigit((int)((number % 10) * 2));
      number = number / 100; // Move to the next even place
    }
    
    return result;
  }
  
  /**
   * This method returns the sum of the two digits in the given number
   * 
   * <pre>Examples:
   * {@code
   * getDigit(9) returns 9
   * getDigit(12) returns 3
   * }<pre>
   * 
   * @param number The number to be checked
   * @return int This number if it is a single digit, otherwise, return the sum of the two digits
   */
  public static int getDigit(int number) {
    return number % 10 + (number / 10);
  }
  
  /**
   * This method returns the sum of the digits in the odd places of the given number
   * 
   * <pre>Examples:
   * {@code
   * sumOfOddPlace(4388576018402626) returns 37
   * sumOfOddPlace(4388576018410707) returns 38
   * }<pre>
   * 
   * @param number The number to be checked
   * @return int The sum of the digits in the odd places of the given number
   */
  public static int sumOfOddPlace(long number) {
    int result = 0;
   
    while (number != 0) {
      result += (int)(number % 10);
      number = number / 100; // Move two positions to the left
    }
    
    return result;
  }
  
  /** 
   * This method returns true if the number d is a prefix for number
   * 
   * <pre>Examples:
   * {@code
   * prefixMatched(4388576018402626, 4) returns true
   * prefixMatched(4388576018402626, 5) returns false
   * }<pre>
   * 
   * @param number The number to be checked
   * @param d The prefix to be checked
   * @return boolean True if the number d is a prefix for number, false otherwise
   */
  public static boolean prefixMatched(long number, int d) {
    return getPrefix(number, getSize(d)) == d;
  }
  
  /**
   * This method returns the number of digits in d
   * 
   * <pre>Examples:
   * {@code
   * getSize(4388576018402626) returns 16
   * getSize(438857601840262) returns 15
   * }<pre>
   * 
   * @param d The number to be checked
   * @return int The number of digits in d
   */
  public static int getSize(long d) {
    int numberOfDigits = 0;
    
    while (d != 0) {
      numberOfDigits++;
      d = d / 10;
    }
    
    return numberOfDigits;
  }
  
  /** 
   * This method returns the first k number of digits from number
   * 
   * <pre>Examples:
   * {@code
   * getPrefix(4388576018402626, 4) returns 4388
   * getPrefix(4388576018402626, 5) returns 43885
   * }<pre>
   * 
   * @param number The number to be checked
   * @param k The number of digits to be returned
   * @return long The first k number of digits from number
   */
  public static long getPrefix(long number, int k) {
    long result = number;
    
    for (int i = 0; i < getSize(number) - k; i++)
      result /= 10;
    
    return result;
  }
}
