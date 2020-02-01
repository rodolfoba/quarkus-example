package quarkus.example.feature.list;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@RequestScoped
@Path("/1.0/list")
public class ItemListResourceV1_0 {

    private ItemListRepository itemListRepository;

    @Inject
    public ItemListResourceV1_0(ItemListRepository itemListRepository) {
        this.itemListRepository = itemListRepository;
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ItemListRestDto getById(@PathParam("id") UUID id) {
        return itemListRepository.findById(new ItemListId(id)).map(ItemListResourceV1_0::toRestDto)
                .orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public Collection<ItemListRestDto> list() {
        return itemListRepository.list().stream().map(ItemListResourceV1_0::toRestDto).collect(Collectors.toList());
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Transactional
    public Response add(ItemListRestDto list) {
        itemListRepository.add(toItemList(list));
        return Response.created(UriBuilder.fromMethod(ItemListResourceV1_0.class, "add").build()).build();
    }

    private static ItemList toItemList(ItemListRestDto dto) {
        return new ItemList(new ItemListId(dto.id), new ItemListName(dto.name));
    }

    private static ItemListRestDto toRestDto(ItemList list) {
        return new ItemListRestDto(list.getId().value(), list.getName().value());
    }

    public static class ItemListRestDto {

        public UUID id;
        public String name;

        public ItemListRestDto() {}

        public ItemListRestDto(UUID id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
