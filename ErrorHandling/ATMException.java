package ErrorHandling;

@SuppressWarnings("serial")
class ATMException extends Exception {
    public ATMException(String message) {
        super(message);
    }
}