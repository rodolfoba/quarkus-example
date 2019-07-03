package quarkus.example.feature.hello.domain.event;

import quarkus.example.infrastructure.tracing.Trace;

public class HelloRequested extends Trace {

    private final String name;

    public HelloRequested(String name) {
        super("HELLO_REQUESTED");
        this.name = name;
    }

}
