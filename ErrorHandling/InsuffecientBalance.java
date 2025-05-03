package ErrorHandling;

@SuppressWarnings("serial")
class InsufficientATMFunds extends ATMException {
    public InsufficientATMFunds(String message) {
        super(message);
    }
}
