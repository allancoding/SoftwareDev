package Course_3.Exercise_44;
import org.junit.*;
import static org.junit.Assert.*;

public class Exercise_44_03 {

  @Test
  public void testIsPalindrome() {
    assertTrue(Course_2.Chapter_06.Exercise_06_03.isPalindrome(12321));
    assertFalse(Course_2.Chapter_06.Exercise_06_03.isPalindrome(123));
    assertTrue(Course_2.Chapter_06.Exercise_06_03.isPalindrome(1));
  }

  @Test
  public void testReverse() {
    assertEquals(Course_2.Chapter_06.Exercise_06_03.reverse(123), 321);
    assertEquals(Course_2.Chapter_06.Exercise_06_03.reverse(12321), 12321);
    assertEquals(Course_2.Chapter_06.Exercise_06_03.reverse(1), 1);
  }
}
