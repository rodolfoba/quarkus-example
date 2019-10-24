package quarkus.example.feature.hello;

import quarkus.example.feature.hello.exception.HelloNotAllowedException;
import quarkus.example.library.UseCase;

import java.time.LocalDateTime;

public class HelloUseCase implements UseCase<Name, String> {

    private final HelloRepository repository;

    public HelloUseCase(HelloRepository repository) {
        this.repository = repository;
    }

    /**
     * Execute Hello use case
     * @param name
     * @return Message
     * @throws HelloNotAllowedException
     */
    @Override
    public String execute(Name name) {
        Hello hello = new Hello(name, LocalDateTime.now());
        repository.save(hello);
        return hello.getMessage();
    }

}
