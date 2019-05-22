package quarkus.example.infrastructure.tracing;

public interface Tracer {

    void trace(Trace trace);

}
