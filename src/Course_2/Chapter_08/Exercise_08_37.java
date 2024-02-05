package Course_2.Chapter_08;
import java.util.Scanner;

public class Exercise_08_37 {
    public static void main(String[] args) {
        String[][] statesAndCapitals = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"}
        };

        int correctCount = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < statesAndCapitals.length; i++) {
            String state = statesAndCapitals[i][0];
            String capital = statesAndCapitals[i][1];

            System.out.print("Enter the capital of " + state + ": ");
            String userCapital = scanner.nextLine();

            if (userCapital.equalsIgnoreCase(capital)) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. The capital of " + state + " is " + capital + ".");
            }
        }
        scanner.close();
        System.out.println("You answered " + correctCount + " out of " + statesAndCapitals.length + " correctly.");
    }
}
