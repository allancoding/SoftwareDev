package Exercise_06;
import java.util.Random;
import java.util.Scanner;

public class Exercise_06_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        scanner.close();
        printMatrix(n);
    }

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
