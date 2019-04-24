package quarkus.example.application;

import java.time.LocalDateTime;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

import quarkus.example.domain.Hello;
import quarkus.example.domain.HelloRepository;

@Dependent
public class HelloApplication {

    @Inject
    HelloRepository repository;

    @Transactional
    public String sayHello(String name) {
        Hello hello = new Hello(name, LocalDateTime.now());
        repository.save(hello);
        return hello.getMessage();
    }

}
