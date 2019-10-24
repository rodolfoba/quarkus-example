package quarkus.example.library;

import java.util.Objects;

public abstract class ValueObject<T> {

    private final T value;

    public ValueObject(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<T> that = (ValueObject<T>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "value=" + value +
                '}';
    }

    public boolean sameAs(ValueObject<T> other) {
        return equals(other);
    }
}
