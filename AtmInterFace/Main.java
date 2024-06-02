public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Bank bank = new Bank();
        ATMInterface atmInterface = new ATMInterface();
        ATM atm = new ATM(bank, atmInterface);

        // Adding some users for demonstration
        User user1 = new User("user1", "1234", 1000);
        User user2 = new User("user2", "5678", 2000);
        bank.addUser(user1);
        bank.addUser(user2);

        atm.start();
    }
}
