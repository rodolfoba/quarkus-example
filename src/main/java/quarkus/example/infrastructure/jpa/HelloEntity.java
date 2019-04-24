package quarkus.example.infrastructure.jpa;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "hello")
public class HelloEntity extends PanacheEntity {

    public String name;
    public LocalDateTime occurredAt;
    
}
