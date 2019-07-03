package quarkus.example.infrastructure.tracing;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trace")
public class TraceEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public String type;
    
    @Column(name = "occurred_at")
    public LocalDateTime occurredAt;
    
}
