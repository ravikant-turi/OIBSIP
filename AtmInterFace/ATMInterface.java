import java.util.Scanner;

public class ATMInterface {
    private Scanner scanner;

    public ATMInterface() {
        scanner = new Scanner(System.in);
    }

    public String promptUserId() {
        System.out.print("Enter User ID: ");
        return scanner.nextLine();
    }

    public String promptUserPin() {
        System.out.print("Enter User PIN: ");
        return scanner.nextLine();
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Choose an option: ");
    }

    public int getMenuChoice() {
        return scanner.nextInt();
    }

    public double promptAmount(String action) {
        System.out.print("Enter amount to " + action + ": ");
        return scanner.nextDouble();
    }

    public String promptRecipientId() {
        System.out.print("Enter recipient User ID: ");
        return scanner.next();
    }
}

