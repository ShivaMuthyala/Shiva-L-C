package ErrorHandling;

@SuppressWarnings("serial")
class ServerConnectionError extends ATMException {
    public ServerConnectionError(String message) {
        super(message);
    }
}
