package Course_4.Chapter_12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_12_15 {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Exercise12_15.txt"), StandardCharsets.UTF_8));
            for (int i = 0; i < 100; i++) {
                writer.print((int) (Math.random() * 100)+ " ");
            }
            writer.close();
            File file = new File("Exercise12_15.txt");
            Scanner input = new Scanner(file);
            int[] array = new int[100];
            for (int i = 0; i < 100; i++) {
                array[i] = input.nextInt();
            }
            input.close();
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
