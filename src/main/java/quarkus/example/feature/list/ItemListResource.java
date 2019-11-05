package quarkus.example.feature.list;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequestScoped
@Path("/list")
public class ItemListResource {

    @Inject
    ItemListRepository itemListRepository;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ItemListRestDto getById(@PathParam("id") UUID id) {
        return itemListRepository.findById(new ItemListId(id)).map(ItemListResource::toRestDto)
                .orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public Collection<ItemListRestDto> list() {
        return itemListRepository.list().stream().map(ItemListResource::toRestDto).collect(Collectors.toList());
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Transactional
    public void add(ItemListRestDto list) {
        itemListRepository.add(toItemList(list));
    }

    private static ItemList toItemList(ItemListRestDto dto) {
        return new ItemList(new ItemListId(dto.id), new ItemListName(dto.name));
    }

    private static ItemListRestDto toRestDto(ItemList list) {
        return new ItemListRestDto(list.getId().value(), list.getName().value());
    }

}
