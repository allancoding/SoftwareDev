package Course_2.Exercise_07;
public class Exercise_07_23 {
    public static void main(String[] args) {
        boolean[] lockers = new boolean[100];
        int students = 2;
        for (int i = 0; i < lockers.length; i++) {
            lockers[i] = false;
        }
        for (int i = 0; i < students; i++) {
            for (int j = i; j < lockers.length; j += i + 1) {
                lockers[j] = !lockers[j];
            }
        }
        System.out.println("The open lockers are: ");
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}