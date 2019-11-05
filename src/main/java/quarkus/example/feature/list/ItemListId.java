package quarkus.example.feature.list;

import quarkus.example.library.ValueObject;

import java.util.UUID;

public class ItemListId extends ValueObject<UUID> {

    public ItemListId(UUID value) {
        super(value);
    }

    public static ItemListId create() {
        return new ItemListId(UUID.randomUUID());
    }
}
