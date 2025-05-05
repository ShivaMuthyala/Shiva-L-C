package ErrorHandling;

class ATM {
    private int atmCash;
    private int dailyLimit;
    private int withdrawnToday = 0;
    private int invalidAttempts = 0;
    private boolean isCardBlocked = false;
    private boolean isServerAvailable = true;
    private static final int MAX_ATTEMPTS = 3;

    public ATM(int atmCash, int dailyLimit) {
        this.atmCash = atmCash;
        this.dailyLimit = dailyLimit;
    }

    public void setServerAvailable(boolean status) {
        this.isServerAvailable = status;
    }

    public void connectToServer() throws ServerConnectionError {
        if (!isServerAvailable) {
            throw new ServerConnectionError("Cannot connect to bank server.");
        }
    }

    public void validatePIN(int enteredPin, User user) throws CardBlockedError, InvalidPINError {
        if (isCardBlocked) {
            throw new CardBlockedError("Your card is blocked due to 3 invalid PIN attempts.");
        }

        if (enteredPin != user.getPin()) {
            invalidAttempts++;
            if (invalidAttempts >= MAX_ATTEMPTS) {
                isCardBlocked = true;
                throw new CardBlockedError("Card blocked after 3 invalid attempts.");
            }
            throw new InvalidPINError("Incorrect PIN. Try again.");
        }

        invalidAttempts = 0;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public boolean isCardBlocked() {
        return isCardBlocked;
    }

    public void withdrawAmount(int amount, int enteredPin, User user) throws ATMException {
        connectToServer();
        validatePIN(enteredPin, user);

        if (amount > atmCash) {
            throw new InsufficientATMFunds("ATM doesn't have enough cash.");
        }

        if (amount > user.getAccountBalance()) {
            throw new InsufficientAccountFunds("Insufficient account balance.");
        }

        if (withdrawnToday + amount > dailyLimit) {
            throw new DailyLimitExceeded("Daily withdrawal limit exceeded.");
        }

        processTransaction(amount, user);
    }

    private void processTransaction(int amount, User user) {
        atmCash -= amount;
        withdrawnToday += amount;
        user.deductBalance(amount);
        System.out.println("Withdrawal successful: $" + amount);
    }
}
