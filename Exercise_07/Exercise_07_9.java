import java.util.Scanner;

public class Exercise_07_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];

        System.out.println("Enter 10 numbers sperarated by a space: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }
        scanner.close();
        double minimum = min(numbers);
        System.out.println("The minimum value is: " + minimum);
    }
    public static double min(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
