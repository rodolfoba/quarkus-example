package quarkus.example.application.hello;

import quarkus.example.infrastructure.tracing.Trace;

public class HelloRefused extends Trace {

    private final String reason;

    public HelloRefused(String reason) {
        super("HELLO_REFUSED");
        this.reason = reason;
    }

}
