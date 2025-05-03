package ErrorHandling;

@SuppressWarnings("serial")
class CardBlockedError extends ATMException {
    public CardBlockedError(String message) {
        super(message);
    }
}
