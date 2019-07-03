package quarkus.example.infrastructure.tracing;

import quarkus.example.infrastructure.tracing.Trace;
import quarkus.example.infrastructure.tracing.Tracer;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;

@Dependent
public class JpaTracer implements Tracer {



    @Override
    @Transactional
    public void trace(Trace trace) {

    }
}
