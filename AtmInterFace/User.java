import java.util.ArrayList;

public class User {
    private String userId;
    private String userPin;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public User(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean authenticate(String pin) {
        return this.userPin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactionHistory.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            this.transactionHistory.add(new Transaction("Withdraw", amount));
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void addTransaction(String type, double amount) {
        this.transactionHistory.add(new Transaction(type, amount));
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}

