package Exams;
/*
Author: Allan Niles
Date: 05/26/2023

Sample input/output:
	income = $200.00,   expense = $100.00,  months = 3, savings = $300.00
	income = $200.00,   expense = $100.00,  months = 6, savings = $600.00
	income = $2000.00,  expense = $800.00,  months = 3, savings = $3600.00
	income = $2000.00,  expense = $800.00,  months = 6, savings = $7200.00
*/
import java.util.Scanner;

class Mod3ExamPart1 {
	public static void main(String[] args) {
            Scanner input  = new Scanner(System.in);
            
            System.out.print("Enter your income for 1 month: $");
            double income = input.nextDouble();
            
            System.out.print("Enter your expenses for 1 month: $");
            double expense = input.nextDouble();
            
            System.out.print("Enter number of months you are saving: ");
            int months = input.nextInt();
            
            // Call method to populate value for savings
            // The call statement is worth 2 pts
            input.close();
            Double savings = findsavings(income, expense, months);
            System.out.printf("After %d months you will have saved $%.2f", months, savings);
        }   
        
        // Create your method here
        // The method header is worth 2 pts
        // The method result is worth 3 pts
        // The method should contain a loop calculating savings for each month
        
        // The loop is worth 3 pts
        public static Double findsavings(double income, double expense, int months) {
            double savings = 0.0;
            for (int i = 0; i < months; i++) {
                savings = (income - expense) * months;
            }
            return savings;
        }    
}
