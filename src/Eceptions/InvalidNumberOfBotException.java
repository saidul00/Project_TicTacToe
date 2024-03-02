package Eceptions;

public class InvalidNumberOfBotException extends RuntimeException{
    public InvalidNumberOfBotException() {
        super();
    }

    public InvalidNumberOfBotException(String message) {
        super(message);
    }

    public InvalidNumberOfBotException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfBotException(Throwable cause) {
        super(cause);
    }

    protected InvalidNumberOfBotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
