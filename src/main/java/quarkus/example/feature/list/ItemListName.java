package quarkus.example.feature.list;

import quarkus.example.library.ExceptionChecker;
import quarkus.example.library.ValueObject;

import java.util.Objects;

public class ItemListName extends ValueObject<String> {

    public ItemListName(String value) {
        super(value);

        Objects.requireNonNull(value, "Name cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (value.equalsIgnoreCase("null")) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public static boolean isValid(String value) {
        return ExceptionChecker.isValid(() -> new ItemListName(value));
    }

}
