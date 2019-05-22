package quarkus.example.application;

public class UseCaseException extends RuntimeException {

    private final Error error;

    public UseCaseException(Error error, String message) {
        super(message);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public interface Error {}
}
