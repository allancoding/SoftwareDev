/*
Author: Allan Niles
Date: 2/6/2023

Sample input/output:
	distance = 100,  cost = $5.00
	distance = 500,  cost = $8.00
	distance = 550,  cost = $10.00
	distance = 1000, cost = $12.00
*/
class Mod2ExamPart1 {
	public static void main(String[] args) {
		int distance = 100;
		double cost = 0.0;
		
		// Insert your code here
		// Each if statement is worth 2 pts
		if(distance <= 0){
            cost = 0.0;
        }else if(distance <= 100){
            cost = 5.00;
        }else if(distance <= 500){
            cost = 8.00;
        }else if(distance < 1000){
            cost = 10.00;
        }else if(distance <= 1000){
            cost = 12.00;
        }
		
		// Turn this print statement into a printf statement
		// Distance should be printed without any trailing zeroes
		// Cost should be printed with 2 trailing zeroes
		// The printf statement is worth 2 pts
		System.out.print("For the package to travel " + distance + " miles it would cost $" + cost + ".");
	}
}