package Course_2.Chapter_03;
import java.util.Scanner;

public class Exercise_03_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a three-digit number you would like to test: ");
        String palindrome = input.nextLine();
        input.close();
        if(palindrome.length() == 3){
            String num1 = palindrome.substring(0,1);
            String num3 = palindrome.substring(2,3);
            if(Integer.parseInt(num1) == Integer.parseInt(num3)){
                System.out.println("The number "+palindrome+" is a palindrome!");
            }else{
                System.out.println("The number "+palindrome+" is not a palindrome!");
            }
        }else{
            System.out.println("The number you entered is not three-digits!");
        }
    }
}