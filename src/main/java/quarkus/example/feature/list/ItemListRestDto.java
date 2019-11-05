package quarkus.example.feature.list;

import java.util.UUID;

public class ItemListRestDto {

    public UUID id;
    public String name;

    public ItemListRestDto() {
    }

    public ItemListRestDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
