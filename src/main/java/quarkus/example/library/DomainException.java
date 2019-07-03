package quarkus.example.library;

public abstract class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
