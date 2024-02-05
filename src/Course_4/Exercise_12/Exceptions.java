package Course_4.Exercise_12;

import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.print("Enter the index of the array: ");
        int index = input.nextInt();
        input.close();
        try {
            System.out.println("The element at index " + index + " is " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }
    }
}