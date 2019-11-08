package quarkus.example.feature.list;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;

public class ItemListMaker {

    public static final Property<ItemList, ItemListId> id = new Property<>();
    public static final Property<ItemList, ItemListName> name = new Property<>();

    public static final Instantiator<ItemList> ItemList = lookup -> new ItemList(
            lookup.valueOf(id, ItemListId.create()),
            lookup.valueOf(name, new ItemListName("Test List")));
}
