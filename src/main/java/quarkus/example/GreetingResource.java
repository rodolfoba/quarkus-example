package quarkus.example;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    @Counted(name = "greetingChecks", monotonic = true, description = "How many greetings have been performed.")
    @Timed(name = "greetingTimer", description = "A measure how long it takes to greet.", unit = MetricUnits.MILLISECONDS)
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "helloChecks", monotonic = true, description = "How many helloes have been performed.")
    @Timed(name = "helloTimer", description = "A measure how long it takes to say hello.", unit = MetricUnits.MILLISECONDS)
    public String hello() {
        return "hello";
    }

}