package Course_4.Exercise_11;
import Course_4.Exercise_09.Account;

public class Polymorphism {
    public static void main(String[] args) {
        Account savingsAccount = new SavingsAccount(1, 1000);
        Account checkingAccount = new CheckingAccount(2, 1000, 500);
        savingsAccount.withdraw(2000);
        checkingAccount.withdraw(2000);
        savingsAccount.toString();
        checkingAccount.toString();
    }

    public static class CheckingAccount extends Account {
        private double overdraftLimit;
        public CheckingAccount() {
            super();
        }
        public CheckingAccount(int id, double balance, double overdraftLimit) {
            super(id, balance);
            this.overdraftLimit = overdraftLimit;
        }
        public void withdraw(double amount) {
            if (getBalance() - amount < overdraftLimit) {
                System.out.println("Overdraft limit exceeded");
            } else {
                setBalance(getBalance() - amount);
            }
        }
        public String toString() {
            return super.toString() + "\nOverdraft limit: " + overdraftLimit;
        }
    }

    public static class SavingsAccount extends Account {
        public SavingsAccount() {
            super();
        }
        public SavingsAccount(int id, double balance) {
            super(id, balance);
        }
        public void withdraw(double amount) {
            if (getBalance() - amount < 0) {
                System.out.println("Insufficient funds");
            } else {
                setBalance(getBalance() - amount);
            }
        }
        public String toString() {
            return super.toString();
        }
    }
}
