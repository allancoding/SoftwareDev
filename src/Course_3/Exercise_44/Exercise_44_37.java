package Course_3.Exercise_44;
import org.junit.*;
import static org.junit.Assert.*;

public class Exercise_44_37 {

    @Test
    public void testFormat() {
        assertEquals(Course_2.Chapter_06.Exercise_06_37.format(123, 5), "00123");
        assertEquals(Course_2.Chapter_06.Exercise_06_37.format(123, 2), "123");
        assertEquals(Course_2.Chapter_06.Exercise_06_37.format(1, 5), "00001");
    }
}
