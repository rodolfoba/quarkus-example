package quarkus.example.feature.hello.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import quarkus.example.feature.hello.domain.HelloRepository;
import quarkus.example.feature.hello.domain.Hello;

import javax.enterprise.context.Dependent;
import javax.persistence.*;
import java.time.LocalDateTime;

@Dependent
public class JpaHelloRepository implements HelloRepository {

    @Override
    public void save(Hello hello) {
        HelloEntity entity = new HelloEntity();
        entity.name = hello.getName().getValue();
        entity.occurredAt = hello.getOccurredAt();
        entity.persist();
    }

    @Entity
    @Table(name = "hello")
    public static class HelloEntity extends PanacheEntityBase {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        public String name;

        @Column(name = "occurred_at")
        public LocalDateTime occurredAt;

    }
}
