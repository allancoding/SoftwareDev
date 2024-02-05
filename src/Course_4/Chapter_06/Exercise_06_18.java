package Course_4.Chapter_06;
import java.util.Scanner;

public class Exercise_06_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String s = input.nextLine();
        if(isValid(s)){
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
        input.close();
    }

    public static boolean isValid(String s){
        if(s.length() < 8){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                return false;
            }
        }
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                count++;
            }
        }
        if(count < 2){
            return false;
        }
        return true;
    } 
}
