package quarkus.example.feature.hello;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import quarkus.example.feature.hello.Hello;
import quarkus.example.feature.hello.HelloRepository;

import javax.enterprise.context.Dependent;
import javax.persistence.*;
import java.time.LocalDateTime;

@Dependent
class JpaHelloRepository implements HelloRepository {

    @Override
    public void save(Hello hello) {
        HelloEntity entity = new HelloEntity();
        entity.name = hello.getName().value();
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