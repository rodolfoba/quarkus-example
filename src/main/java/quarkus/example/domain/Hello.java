package quarkus.example.domain;

import java.time.LocalDateTime;

public class Hello {

    private final String name;
    private final LocalDateTime occurredAt;
    
    public Hello(String name, LocalDateTime occurredAt) {
        this.name = name;
        this.occurredAt = occurredAt;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public String getMessage() {
        return "Hello " + name + " at " + occurredAt.toString();
    }
    
}
