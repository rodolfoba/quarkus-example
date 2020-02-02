package quarkus.example.feature.list;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.Dependent;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Dependent
class JpaItemListRepository implements ItemListRepository {

    @Override
    public Optional<ItemList> findById(ItemListId id) {
        return Optional.ofNullable((ItemListEntity) ItemListEntity.findById(id.value()))
                .map(JpaItemListRepository::fromEntity);
    }

    @Override
    public List<ItemList> list() {
        return ItemListEntity.listAll().stream().map(JpaItemListRepository::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void add(ItemList list) {
        ItemListEntity.persist(toEntity(list));
    }

    private static ItemListEntity toEntity(ItemList list) {
        return new ItemListEntity(list.getId().value(), list.getName().value());
    }

    private static ItemList fromEntity(PanacheEntityBase panacheEntity) {
        var entity = (ItemListEntity) panacheEntity;
        return new ItemList(new ItemListId(entity.id), new ItemListName(entity.name));
    }
}