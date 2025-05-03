package ErrorHandling;

@SuppressWarnings("serial")
class DailyLimitExceeded extends ATMException {
    public DailyLimitExceeded(String message) {
        super(message);
    }
}
