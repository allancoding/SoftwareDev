package Exercise_04;
import java.util.Scanner;

public class Exercise_04_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer (0 - 127): ");
        int ascii = input.nextInt();
        input.close();
        if(ascii > -1 && ascii < 128){
            System.out.println("ASCII Code: "+ascii);
            System.out.println("Character: '"+ (char) ascii+"'");
        }else{
            System.out.println("That integer is not in the correct range (0-127)");
            System.exit(0);
        }
    }
}