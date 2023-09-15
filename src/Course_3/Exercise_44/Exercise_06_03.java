package Course_3.Exercise_44;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

public class Exercise_06_03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a postive integer: ");
    int number = input.nextInt();
    input.close();
    if (isPalindrome(number)) 
      System.out.println(number + " is a palindrome");
    else
      System.out.println(number + " is not a palindrome");
  }
  
  @Test
  public static boolean isPalindrome(int number) {
    return number == reverse(number);
  }

  @Test
  public static int reverse(int number) {
    int result = 0;
    while (number != 0) {
      int remainder = number % 10;

      result = result * 10 + remainder;

      number = number / 10;
    }

    return result;
  }

  @Test
  public void testIsPalindrome() {
    assertTrue(Exercise_06_03.isPalindrome(12321));
    assertFalse(Exercise_06_03.isPalindrome(123));
    assertTrue(Exercise_06_03.isPalindrome(1));
  }

  @Test
  public void testReverse() {
    assertEquals(Exercise_06_03.reverse(123), 321);
    assertEquals(Exercise_06_03.reverse(12321), 12321);
    assertEquals(Exercise_06_03.reverse(1), 1);
  }
}
