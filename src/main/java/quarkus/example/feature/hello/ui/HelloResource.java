package quarkus.example.feature.hello.ui;

import quarkus.example.feature.hello.application.HelloUseCase;
import quarkus.example.feature.hello.domain.Name;
import quarkus.example.library.UseCaseException;
import quarkus.example.library.DomainException;
import quarkus.example.feature.hello.infrastructure.beanvalidation.ValidName;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@RequestScoped
@Path("/hello")
public class HelloResource {

    @Inject
    HelloUseCase useCase;

    @GET
    @Path("/{name}")
    @Produces(TEXT_PLAIN)
    public String hello(@PathParam("name") @ValidName String name) {
        try {
            return useCase.execute(new Name(name));
        } catch (UseCaseException | DomainException e) {
            throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build());

        }
    }
    
    @GET
    @Path("/")
    @Produces(TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World";
    }
    
}
