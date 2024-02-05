package Course_2.Chapter_07;
import java.util.Scanner;

public class Exercise_07_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Enter numbers separated by a space: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        int[] uniqueNumbers = eliminateDuplicates(numbers);

        System.out.println("Array without duplicates:");
        for (int number : uniqueNumbers) {
            System.out.print(number + " ");
        }
    }
    public static int[] eliminateDuplicates(int[] list) {
        int[] result = new int[list.length];
        int index = 0;

        for (int i = 0; i < list.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (list[i] == result[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index] = list[i];
                index++;
            }
        }

        int[] trimmedResult = new int[index];
        System.arraycopy(result, 0, trimmedResult, 0, index);
        return trimmedResult;
    }
}
