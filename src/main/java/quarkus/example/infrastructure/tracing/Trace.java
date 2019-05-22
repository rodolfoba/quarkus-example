package quarkus.example.infrastructure.tracing;

public abstract class Trace {

    private final String type;

    public Trace(String type) {
        this.type = type;

    }

}
