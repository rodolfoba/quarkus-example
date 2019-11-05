package quarkus.example.feature.list;

public class ItemList {

    private final ItemListId id;
    private final ItemListName name;

    public ItemList(ItemListId id, ItemListName name) {
        this.id = id;
        this.name = name;
    }

    public ItemListId getId() {
        return id;
    }

    public ItemListName getName() {
        return name;
    }
}
