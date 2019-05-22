package quarkus.example.application.hello;

import quarkus.example.application.UseCase;
import quarkus.example.application.UseCaseException;
import quarkus.example.domain.Hello;
import quarkus.example.domain.HelloRepository;

import java.time.LocalDateTime;

class HelloUseCase implements UseCase<String, String> {

    private final HelloRepository repository;

    HelloUseCase(HelloRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(String name) {
        if (null == name || name.isBlank()) {
            throw new UseCaseException(Errors.INVALID_NAME, "Invalid name");
        }

        Hello hello = new Hello(name, LocalDateTime.now());
        repository.save(hello);

        return hello.getMessage();
    }

    enum Errors implements UseCaseException.Error {
        INVALID_NAME
    }
}
