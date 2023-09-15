package Course_2.Exercise_03;
import java.util.Scanner;

public class Exercise_03_14 {
    public static void main(String[] args) {
        System.out.println("A coin has been flipped!");
        System.out.println("0) Heads");
        System.out.println("1) Tails");
        Scanner input = new Scanner(System.in);
        System.out.print("Guess heads or tails: ");
        Integer guess = input.nextInt();
        input.close();
        int random = (int)(Math.random() * 2 + 1);
        random = random -1;
        if(guess == random){
            System.out.println("You are correct! You beat the computer humanity will survive!");
        }else{
            System.out.println("You are wrong! Computers will now take over the world!");
        }
    }
}