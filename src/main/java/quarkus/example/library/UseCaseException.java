package quarkus.example.library;

public class UseCaseException extends RuntimeException {

    public UseCaseException(String message) {
        super(message);
    }

    public UseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
