/*
Author: Allan Niles
Date: 6/7/2023
*/

import java.util.Scanner;

class Mod5Exam {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int user = 0;

		while (user != 1 && user != 2) {
			System.out.println("Which action would you like to perform?");
			System.out.println("\t1) Print Exam Grades");
			System.out.println("\t2) Track Attendance");
			System.out.print("Choose a menu item: ");

			user = input.nextInt();
		}

		if (user == 1) {
			printExam(input);
		} else {
			trackAtt(input);
		}
		input.close();
	}
	
	
	/*
	 * Accepts 25 scores and prints the average score and the number of A, B, C, D, and F.
	 *
	 * Example:
	 *     Input: 70.11 46.33 50.54 94.66 74.40 64.12 84.07 63.50 91.12 44.74 74.88 41.83 84.62 67.08 57.53 92.01 66.11 88.10 69.75 66.54 83.57 49.31 69.71 45.15 53.57
	 *
	 *     Output: 
	 *         Average score: 67.73%
	 *         Number of A's: 3
	 *  	   Number of B's: 4
	 *         Number of C's: 3
	 * 		   Number of D's: 7
	 *         Number of F's: 8
	 */
	public static void printExam(Scanner input) {
        double[] scores = new double[25];
		int count = 0;
		input.nextLine();
        System.out.print("Enter 25 scores (separated by spaces): ");
        while (count < 25) {
            String[] scoreStrings = input.nextLine().trim().split("\\s+");

            for (String scoreString : scoreStrings) {
                try {
                    double score = Double.parseDouble(scoreString);
                    scores[count] = score;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid score.");
                }

                if (count >= 25) {
                    break;
                }
            }

            if (count < 25) {
                int scoresEntered = count;
                int scoresRemaining = 25 - scoresEntered;
                System.out.print("You have entered " + scoresEntered + ", enter " + scoresRemaining + " more: ");
            }
        }

        double average = calculateAverage(scores);
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int numD = 0;
        int numF = 0;

        for (double score : scores) {
            if (score >= 90.0) {
                numA++;
            } else if (score >= 80.0) {
                numB++;
            } else if (score >= 70.0) {
                numC++;
            } else if (score >= 60.0) {
                numD++;
            } else {
                numF++;
            }
        }

        System.out.println("Average score: " + average + "%");
        System.out.println("Number of A's: " + numA);
        System.out.println("Number of B's: " + numB);
        System.out.println("Number of C's: " + numC);
        System.out.println("Number of D's: " + numD);
        System.out.println("Number of F's: " + numF);
    }

    public static double calculateAverage(double[] scores) {
        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
	
	/*
	 * Display the number of days absent for the seating chart of a 5x5 classroom. 
	 * (Hint: Your array should reflect the classroom layout to be given points.)
	 *
	 * Example:
	 *     Input: 
	 *	       2 days
	 *	       0 0 1 0 0
	 *	       0 1 1 0 0
	 *	       0 0 0 0 0
	 *	       1 0 0 1 0
	 *	       0 0 0 0 0
	 *
	 *	       0 0 0 0 0
	 *	       0 1 0 0 0
	 *	       0 0 0 1 0
	 *	       1 0 0 0 0
	 *	       0 0 1 0 0 
	 *     Output: 
	 *         0 0 1 0 0
	 *         0 2 1 0 0
	 *  	   0 0 0 1 0
	 *         2 0 0 1 0
	 * 		   0 0 1 0 0
	 */

	public static void trackAtt(Scanner input) {
		int[][] att = new int[5][5]; // Two-dimensional array for attendance
		int days = 0;

		System.out.print("\nHow many days would you like to enter? ");
		days = input.nextInt();

		System.out.println("This is the diagram of your seating chart. Enter attendance to match this chart.\n");
		System.out.println("       Front of Room");
		System.out.println("|--------------------------------|");
		System.out.println("|  [ 1]  [ 2]  [ 3]  [ 4]  [ 5]  |");
		System.out.println("|  [ 6]  [ 7]  [ 8]  [ 9]  [10]  |");
		System.out.println("|  [11]  [12]  [13]  [14]  [15]  |");
		System.out.println("|  [16]  [17]  [18]  [19]  [20]  |");
		System.out.println("|  [21]  [22]  [23]  [24]  [25]  |");
		System.out.println("|________________________________|");

		for (int d = 0; d < days; d++) {
            System.out.println("\nDay " + (d + 1));
            for (int r = 0; r < att.length; r++) {
                System.out.print("Enter 5 numbers for row " + (r + 1) + " (1 = absent, 0 = present): ");
                for (int c = 0; c < att[r].length; c++) {
                    att[r][c] += input.nextInt(); // Add the attendance to the existing value
                }
            }
        }

        System.out.println("\nAttendance record:");
        for (int r = 0; r < att.length; r++) {
            for (int c = 0; c < att[r].length; c++) {
                System.out.print(att[r][c] + " ");
            }
            System.out.println();
        }
	}
}
