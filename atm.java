import java.util.Scanner;

public class atm {
    private double balance;

    public atm(double initialBalance) {
        this.balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } else {
            if (amount < 0)
                System.out.println("Invalid withdrawal amount ");
            if (amount > balance) {
                System.out.println("insufficient balance");
            }
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public static void main(String[] args) {

        atm myATM = new atm(1000.0); // Initialize ATM with $1000 balance

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + myATM.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    myATM.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    myATM.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
