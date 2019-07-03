package quarkus.example.feature.hello.domain;

import quarkus.example.feature.hello.domain.exception.HelloNotAllowedException;

import java.time.LocalDateTime;

public class Hello {

    private static final Name FORBIDDEN_NAME =  new Name("Voldemort");

    private final Name name;
    private final LocalDateTime occurredAt;

    /**
     * Hello
     * @param name
     * @param occurredAt
     * @throws HelloNotAllowedException
     */
    public Hello(Name name, LocalDateTime occurredAt) {
        if (FORBIDDEN_NAME.equals(name)) {
            throw new HelloNotAllowedException("Cannot say hello to a forbidden name");
        }

        this.name = name;
        this.occurredAt = occurredAt;
    }
    
    public Name getName() {
        return name;
    }
    
    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public String getMessage() {
        return "Hello " + name.getValue() + " at " + occurredAt.toString();
    }
    
}
