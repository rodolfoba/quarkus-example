package quarkus.example.application.hello;

import quarkus.example.domain.Hello;
import quarkus.example.infrastructure.tracing.Trace;

public class HelloAccomplished extends Trace {

    private final Hello hello;

    public HelloAccomplished(Hello hello) {
        super("HELLO_ACCOMPLISHED");
        this.hello = hello;
    }
}
