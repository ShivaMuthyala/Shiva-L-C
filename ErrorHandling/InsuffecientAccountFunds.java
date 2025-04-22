package ErrorHandling;

@SuppressWarnings("serial")
class InsufficientAccountFunds extends ATMException {
    public InsufficientAccountFunds(String message) {
        super(message);
    }
}
