package Course_2.Chapter_04;
import java.util.Scanner;

public class Exercise_04_22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String 1: ");
        String s1 = input.nextLine();
        System.out.print("Enter a String 2: ");
        String s2 = input.nextLine();
        input.close();
        if(s1.length() > s2.length()){
            if(s1.contains(s2)){
                System.out.println("'"+s2+"' is a substring of '"+s1+"'");
            }else{
                System.out.println("'"+s2+"' is not a substring of '"+s1+"'");
            }
        }else if(s1.length() < s2.length()){
            System.out.println(s2+" is longer than "+s1);
        }else{
            System.out.println(s1+" and "+s2+" are the same length");
        }
        

    }
}