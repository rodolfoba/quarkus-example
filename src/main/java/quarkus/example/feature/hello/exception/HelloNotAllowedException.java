package quarkus.example.feature.hello.exception;

import quarkus.example.library.DomainException;

public class HelloNotAllowedException extends DomainException {

    public HelloNotAllowedException(String message) {
        super(message);
    }
}
