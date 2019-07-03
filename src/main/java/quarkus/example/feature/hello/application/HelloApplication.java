package quarkus.example.feature.hello.application;

import quarkus.example.feature.hello.domain.HelloRepository;
import quarkus.example.feature.hello.domain.Name;
import quarkus.example.infrastructure.tracing.Traceable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Dependent
public class HelloApplication extends HelloUseCase {

    @Inject
    public HelloApplication(HelloRepository repository) {
        super(repository);
    }

    @Traceable
    @Transactional
    @Override
    public String execute(Name name) {
        return super.execute(name);
    }
}
