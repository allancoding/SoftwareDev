package Course_4.Chapter_10;
import java.util.Scanner;

import Course_4.Chapter_09.Account;

public class Exercise_10_07 {
    public static void main(String[] args) {
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter -1 to exit.");
            System.out.print("Enter an id: ");
            int id = input.nextInt();
            if (id == -1) {
                input.close();
                System.out.println("Goodbye.");
                break;
            } else if (id < 0 || id > 9) {
                System.out.println("Invalid id.");
                continue;
            }
            while (true) {
                System.out.println("Main menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("The balance is " + accounts[id].getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to withdraw: ");
                        accounts[id].withdraw(input.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter an amount to deposit: ");
                        accounts[id].deposit(input.nextDouble());
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                if (choice == 4) {
                    break;
                }
            }
            
        }
    }
}
