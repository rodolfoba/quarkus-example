package quarkus.example.application.hello;

import quarkus.example.domain.HelloRepository;
import quarkus.example.infrastructure.tracing.Traceable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Dependent
public class HelloApplication {

    @Inject
    HelloRepository repository;

    @Transactional
    @Traceable
    public String sayHello(String name) {
        HelloUseCase useCase = new HelloUseCase(repository);
        return useCase.execute(name);
//        return "oi";
    }

}
