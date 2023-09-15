package Course_2.Exercise_05;
public class Exercise_05_3 {
    public static void main(String[] args) {
        double POUNDS_PER_KILOGRAM = 2.2;
		System.out.println("Kilograms      Pounds");
		for (int i = 1; i <= 199; i += 2) {
			System.out.printf(
				"%-15d%6.1f\n", i, (i * POUNDS_PER_KILOGRAM));  	
		}  
    }
}