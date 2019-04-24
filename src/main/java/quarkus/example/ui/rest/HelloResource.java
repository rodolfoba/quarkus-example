package quarkus.example.ui.rest;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import quarkus.example.application.HelloApplication;

@RequestScoped
@Path("/hello")
public class HelloResource {

    @Inject
    HelloApplication application;

    @GET
    @Path("/{name}")
    @Produces(TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return application.sayHello(name);
    }
    
    @GET
    @Path("/")
    @Produces(TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World";
    }
    
}
