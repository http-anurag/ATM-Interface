package atm.com.web.jdbc;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private Map<String, Double> accounts; // Simulated user accounts (in-memory database)
    private String currentUser;

    public ATM() {
        accounts = new HashMap<>();
        accounts.put("123456", 1000.0); // Sample account with user ID "123456" and initial balance 1000.0
        currentUser = null;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.print("Enter your user ID: ");
            String userID = scanner.nextLine();
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();

            if (authenticate(userID, pin)) {
                System.out.println("Authentication successful.");
                currentUser = userID;
                break;
            } else {
                System.out.println("Authentication failed. Please try again.");
            }
        }

        while (currentUser != null) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    currentUser = null;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private boolean authenticate(String userID, String pin) {
        // Simulated authentication logic
        if (accounts.containsKey(userID) && pin.equals("1234")) { // Simple PIN check for demonstration
            return true;
        }
        return false;
    }

    private void viewTransactionHistory() {
        // Simulated transaction history retrieval
        System.out.println("Transaction history for user " + currentUser + ":");
        // You would typically fetch and display transaction history from a database here.
    }

    private void withdraw() {
        // Simulated withdrawal logic
        System.out.print("Enter the amount to withdraw: ");
        double amount = new Scanner(System.in).nextDouble();
        double balance = accounts.get(currentUser);

        if (amount > 0 && balance >= amount) {
            accounts.put(currentUser, balance - amount);
            System.out.println("Withdrawal successful. Remaining balance: " + accounts.get(currentUser));
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private void deposit() {
        // Simulated deposit logic
        System.out.print("Enter the amount to deposit: ");
        double amount = new Scanner(System.in).nextDouble();
        double balance = accounts.get(currentUser);

        if (amount > 0) {
            accounts.put(currentUser, balance + amount);
            System.out.println("Deposit successful. New balance: " + accounts.get(currentUser));
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void transfer() {
        // Simulated transfer logic
        System.out.print("Enter the recipient's user ID: ");
        String recipient = new Scanner(System.in).nextLine();
        if (!accounts.containsKey(recipient)) {
            System.out.println("Recipient not found.");
            return;
        }

        System.out.print("Enter the amount to transfer: ");
        double amount = new Scanner(System.in).nextDouble();
        double senderBalance = accounts.get(currentUser);
        double recipientBalance = accounts.get(recipient);

        if (amount > 0 && senderBalance >= amount) {
            accounts.put(currentUser, senderBalance - amount);
            accounts.put(recipient, recipientBalance + amount);
            System.out.println("Transfer successful. Remaining balance: " + accounts.get(currentUser));
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
