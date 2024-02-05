package Course_2.Chapter_05;
public class Exercise_05_11 {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("Counting from : 100 - 200");
        System.out.println("Divisible by 5 or 6, but not 5 and 6");
        System.out.println("-----------------------------------------");
        for (int i = 100; i <= 200; i++) {
            if ((i % 5 == 0 || i % 6 == 0) && !(i % 5 == 0 && i % 6 == 0)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

}