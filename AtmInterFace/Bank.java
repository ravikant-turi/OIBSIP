import java.util.HashMap;

public class Bank {
    private HashMap<String, User> users;

    public Bank() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public boolean authenticateUser(String userId, String pin) {
        User user = users.get(userId);
        return user != null && user.authenticate(pin);
    }
}

