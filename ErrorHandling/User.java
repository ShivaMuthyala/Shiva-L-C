package ErrorHandling;

public class User {
    private final int pin = 1234;
    private int accountBalance = 1000;

    public int getPin() {
        return pin;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void deductBalance(int amount) {
        accountBalance -= amount;
    }
}
