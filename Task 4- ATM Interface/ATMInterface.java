import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (userAccount.getBalance() >= amount) {
            userAccount.setBalance(userAccount.getBalance() - amount);
            System.out.println("Withdrawal successful. Current balance: " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Current balance: " + userAccount.getBalance());
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        userAccount.setBalance(userAccount.getBalance() + amount);
        System.out.println("Deposit successful. Current balance: " + userAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.println("Enter your initial account balance:");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
