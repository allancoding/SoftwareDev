package Course_4.Exercise_09;
import java.util.Date;

public class Exercise_09_07 {

    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Monthly interest: " + account.getMonthlyInterest());
        System.out.println("Date created: " + account.getDateCreated());
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    Account() {
        dateCreated = new Date();
    }
    Account(int newId, double newBalance) {
        id = newId;
        balance = newBalance;
        dateCreated = new Date();
    }
    int getId() {
        return id;
    }
    void setId(int newId) {
        id = newId;
    }
    double getBalance() {
        return balance;
    }
    void setBalance(double newBalance) {
        balance = newBalance;
    }
    double getAnnualInterestRate() {
        return annualInterestRate;
    }
    void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }
    Date getDateCreated() {
        return dateCreated;
    }
    double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }
    void withdraw(double amount) {
        balance -= amount;
    }
    void deposit(double amount) {
        balance += amount;
    }
}
