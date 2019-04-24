package quarkus.example.infrastructure.jpa;

import javax.enterprise.context.Dependent;

import quarkus.example.domain.Hello;
import quarkus.example.domain.HelloRepository;

@Dependent
public class JpaHelloRepository implements HelloRepository {

    @Override
    public void save(Hello hello) {
        HelloEntity entity = new HelloEntity();
        entity.name = hello.getName();
        entity.occurredAt = hello.getOccurredAt();
        entity.persist();
    }

}
