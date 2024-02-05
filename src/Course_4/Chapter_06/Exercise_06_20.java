package Course_4.Chapter_06;
import java.util.Scanner;

public class Exercise_06_20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.println("'" + s + "' is " + s.length() + " characters long");
        System.out.println("There are " + countLetters(s) + " letters in '" + s + "'");
        input.close();
    }

    public static int countLetters(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
