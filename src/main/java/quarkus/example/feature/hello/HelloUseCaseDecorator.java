package quarkus.example.feature.hello;

import quarkus.example.infrastructure.tracing.Traceable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Dependent
public class HelloUseCaseDecorator extends HelloUseCase {

    @Inject
    public HelloUseCaseDecorator(HelloRepository repository) {
        super(repository);
    }

    @Traceable
    @Transactional
    @Override
    public String execute(Name name) {
        return super.execute(name);
    }
}
