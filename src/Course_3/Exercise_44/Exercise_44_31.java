package Course_3.Exercise_44;
import org.junit.*;
import static org.junit.Assert.*;

public class Exercise_44_31 {

    @Test
    public void testIsValid() {
        // Test size >= 13 and size <= 16
        assertFalse(Course_2.Exercise_06.Exercise_06_31.isValid(76009244561L));  // Invalid: size < 13
        assertTrue(Course_2.Exercise_06.Exercise_06_31.isValid(4012888888881881L));   // Valid: size = 16
        assertFalse(Course_2.Exercise_06.Exercise_06_31.isValid(50197170101037421L));   // Invalid: size > 16
        
        // Test prefix of 4, 5, 6, or 37
        assertFalse(Course_2.Exercise_06.Exercise_06_31.isValid(338857601840263L));  // Invalid: incorrect prefix
        assertTrue(Course_2.Exercise_06.Exercise_06_31.isValid(4388576018410707L));   // Valid: prefix = 4
        assertFalse(Course_2.Exercise_06.Exercise_06_31.isValid(5388576018410707L));   // Valid: prefix = 5
        assertTrue(Course_2.Exercise_06.Exercise_06_31.isValid(6011111111111117L));   // Valid: prefix = 6
        assertTrue(Course_2.Exercise_06.Exercise_06_31.isValid(378282246310005L));   // Valid: prefix = 37

        // Test (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0
        assertFalse(Course_2.Exercise_06.Exercise_06_31.isValid(438857601840263L));  // Invalid: condition false
        assertTrue(Course_2.Exercise_06.Exercise_06_31.isValid(4388576018410707L));   // Valid: condition true
    }
}
