package quarkus.example.feature.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class FakeItemListRepository implements ItemListRepository {

    private final Collection<ItemList> lists;

    public FakeItemListRepository() {
        lists = new ArrayList<>();
    }

    public FakeItemListRepository(ItemList itemList) {
        this();
        lists.add(itemList);
    }

    public FakeItemListRepository(List<ItemList> lists) {
        this();
        this.lists.addAll(lists);
    }

    @Override
    public Optional<ItemList> findById(ItemListId id) {
        return lists.stream().filter(c -> c.getId().sameAs(id)).findFirst();
    }

    @Override
    public List<ItemList> list() {
        return new ArrayList<>(lists);
    }

    @Override
    public void add(ItemList itemList) {
        lists.add(itemList);
    }
}
