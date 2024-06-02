public class ATM {
    private Bank bank;
    private ATMInterface atmInterface;

    public ATM(Bank bank, ATMInterface atmInterface) {
        this.bank = bank;
        this.atmInterface = atmInterface;
    }

    public void start() {
        String userId = atmInterface.promptUserId();
        String userPin = atmInterface.promptUserPin();

        if (bank.authenticateUser(userId, userPin)) {
            User user = bank.getUser(userId);
            boolean quit = false;
            while (!quit) {
                atmInterface.displayMenu();
                int choice = atmInterface.getMenuChoice();

                switch (choice) {
                    case 1:
                        displayTransactionHistory(user);
                        break;
                    case 2:
                        withdraw(user);
                        break;
                    case 3:
                        deposit(user);
                        break;
                    case 4:
                        transfer(user);
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.....");
                }
            }
        } else {
            System.out.println("Authentication failed. Please try again.......");
        }
    }

    private void displayTransactionHistory(User user) {
        System.out.println("\nTransaction History:");
        for (Transaction t : user.getTransactionHistory()) {
            System.out.println(t);
        }
    }

    private void withdraw(User user) {
        double amount = atmInterface.promptAmount("withdraw");
        user.withdraw(amount);
    }

    private void deposit(User user) {
        double amount = atmInterface.promptAmount("deposit");
        user.deposit(amount);
    }

    private void transfer(User user) {
        String recipientId = atmInterface.promptRecipientId();
        User recipient = bank.getUser(recipientId);

        if (recipient != null) {
            double amount = atmInterface.promptAmount("transfer");
            if (user.getBalance() >= amount) {
                user.withdraw(amount);
                recipient.deposit(amount);
                user.addTransaction("Transfer to " + recipientId, amount);
                recipient.addTransaction("Transfer from " + user.getUserId(), amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Recipient not found.");
        }
    }
}
