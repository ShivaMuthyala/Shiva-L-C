package ErrorHandling;

@SuppressWarnings("serial")
class InvalidPINError extends ATMException {
    public InvalidPINError(String message) {
        super(message);
    }
}