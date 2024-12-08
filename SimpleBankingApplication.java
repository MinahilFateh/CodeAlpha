import java.util.Scanner;

public class SimpleBankingApplication {
    private double balance;

    public SimpleBankingApplication() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your balance is: $" + balance);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleBankingApplication bankingApp = new SimpleBankingApplication();
        int choice;

        do {
            System.out.println("\nWelcome to the Simple Banking Application");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    bankingApp.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    bankingApp.withdraw(withdrawAmount);
                    break;
                case 3:
                    bankingApp.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}