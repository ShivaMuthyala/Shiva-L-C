package ErrorHandling;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ATM atm = new ATM(100000, 500);
        atm.setServerAvailable(true);

        User user = new User();

        boolean sessionActive = initiateSession(scanner, atm, user);

        if (sessionActive) {
            processATMMenu(scanner, atm, user);
        }

        scanner.close();
    }

    private static boolean initiateSession(Scanner scanner, ATM atm, User user) {
        int attempts = 0;
        int enteredPin = 0;
        boolean sessionActive = true;
        final int maxAttempts = atm.getMaxAttempts();

        while (attempts < maxAttempts) {
            System.out.print("Enter your PIN: ");
            enteredPin = scanner.nextInt();
            scanner.nextLine();

            if (enteredPin == user.getPin()) {
                return true;
            } else {
                attempts++;
                System.out.println("❌ Incorrect PIN. You have " + (maxAttempts - attempts) + " attempts left.");
                if (attempts == maxAttempts) {
                    System.out.println("❌ Too many incorrect attempts. Your card is blocked.");
                    sessionActive = false;
                    break;
                }
            }
        }
        return sessionActive;
    }

    private static void processATMMenu(Scanner scanner, ATM atm, User user) {
        boolean sessionActive = true;

        while (sessionActive) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Simulate Server Down");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    processWithdrawal(scanner, atm, user);
                    break;

                case 2:
                    simulateServerDown(atm);
                    break;

                case 3:
                    sessionActive = false;
                    System.out.println("👋 Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("❗ Invalid option. Try again.");
            }
        }
    }

    private static void processWithdrawal(Scanner scanner, ATM atm, User user) {
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        try {
            atm.withdrawAmount(amount, user.getPin(), user);
        } catch (ATMException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }

    private static void simulateServerDown(ATM atm) {
        atm.setServerAvailable(false);
        System.out.println("Server is now set to DOWN.");
    }
}
