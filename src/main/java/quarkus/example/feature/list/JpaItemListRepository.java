package quarkus.example.feature.list;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Entity
    @Table(name = "list")
    static class ItemListEntity extends PanacheEntityBase {

        @Id
        @Column(name = "id")
        public UUID id;

        @Column(name = "name")
        public String name;

        ItemListEntity() {
            super();
        }

        ItemListEntity(UUID id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}