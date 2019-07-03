package quarkus.example.feature.hello.domain;

import quarkus.example.library.ExceptionChecker;

import java.util.Objects;

public class Name {

    private final String value;

    public Name(String value) {
        Objects.requireNonNull(value, "Name cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (value.equalsIgnoreCase("null")) {
            throw new IllegalArgumentException("Invalid name");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValid(String value) {
        return ExceptionChecker.isValid(() -> new Name(value));
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
