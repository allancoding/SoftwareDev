package Exercise_03;
import java.util.Scanner;

public class Exercise_03_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year as four digits: ");
        Integer year = input.nextInt();
        System.out.print("Enter a month (1-12): ");
        Integer month = input.nextInt();
        System.out.print("Enter a day of the month: ");
        Integer day = input.nextInt();
        input.close();
        int m = 0;
        if(month == 1){
            m = 13;
        }else if(month == 2){
            m  = 14;
        }else{
            m = month;
        }
        int j = year / 100;
        int k = year % 100;
        int q = day;
        int h = (q+(26*(m+1)/10)+k+k/4+j/4+5*j)%7;
        String week = "day";
        if(h == 0){
            week = "Saturday";
        }else if(h == 1){
            week = "Sunday";
        }else if(h == 2){
            week = "Monday";
        }else if(h == 3){
            week = "Tuesday";
        }else if(h == 4){
            week = "Wednesday";
        }else if(h == 5){
            week = "Thursday";
        }else if(h == 6){
            week = "Friday";
        }
        System.out.println("The day of the week is: "+week);
    }
}