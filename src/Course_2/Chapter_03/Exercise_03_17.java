package Course_2.Chapter_03;
import java.util.Scanner;

public class Exercise_03_17 {
    public static void main(String[] args) {
        System.out.println("You have been challenged!");
        System.out.println("0) Rock");
        System.out.println("1) Paper");
        System.out.println("2) Scissors");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for you the play: ");
        Integer guess = input.nextInt();
        input.close();
        int random = (int)(Math.random() * 3 + 1);
        random = random -1;
        System.out.println(" ");
        System.out.println("The Computer played: "+random);
        if(guess == random){
            System.out.println("You tided...");
        }else if(guess == 0 && random == 1){
            System.out.println("You won... You beat the computer humanity will survive!");
        }else if(guess == 0 && random == 2){
            System.out.println("You lost... Computers will now take over the world!");
        }else if(guess == 1 && random == 2){
            System.out.println("You won... You beat the computer humanity will survive!");
        }else if(guess == 1 && random == 0){
            System.out.println("You lost... Computers will now take over the world!");
        }else if(guess == 2 && random == 0){
            System.out.println("You won... You beat the computer humanity will survive!");
        }else if(guess == 2 && random == 1){
            System.out.println("You lost... Computers will now take over the world!");
        }else{
            System.out.println("You failed! The number "+guess+" is not a option!");
        }
    }
}