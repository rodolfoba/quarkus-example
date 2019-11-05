package quarkus.example.feature.list;

import java.util.List;
import java.util.Optional;

interface ItemListRepository {

    Optional<ItemList> findById(ItemListId id);
    List<ItemList> list();
    void add(ItemList toItemList);

}
