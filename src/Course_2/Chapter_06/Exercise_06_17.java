package Course_2.Chapter_06;
import java.util.Random;
import java.util.Scanner;

/**
 * <h1>Exercise 6-17</h1>
 * <p>This is used to print an n-by-n matrix of 0s and 1s</p>
 * 
 * <p>Created: 9/25/2023</p>
 * <p>Modified: 9/25/2023</p>
 * 
 * @author Allan Niles
 */
public class Exercise_06_17 {
    
    /** 
     * This is the main method (entry point) that gets called by the JVM
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        scanner.close();
        printMatrix(n);
    }

    /** 
     * This method prints an n-by-n matrix of 0s and 1s
     * 
     * <pre>Examples:
     * {@code printMatrix(3) prints
     * 0 1 0
     * 0 0 0
     * 1 1 1}</pre>
     * 
     * @param n The size of the matrix
     */
    public static void printMatrix(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = random.nextInt(2);
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
