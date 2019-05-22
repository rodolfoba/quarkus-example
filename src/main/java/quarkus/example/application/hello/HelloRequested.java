package quarkus.example.application.hello;

import quarkus.example.infrastructure.tracing.Trace;

public class HelloRequested extends Trace {

    private final String name;

    public HelloRequested(String name) {
        super("HELLO_REQUESTED");
        this.name = name;
    }

}
