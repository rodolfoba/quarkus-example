package quarkus.example;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

@RequestScoped
@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    @Counted(name = "greetingChecks", description = "How many greetings have been performed.", absolute = true)
    @Timed(name = "greetingTimer", description = "A measure how long it takes to greet.", absolute = true, unit = MetricUnits.MILLISECONDS)
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "helloChecks", description = "How many helloes have been performed.", absolute = true)
    @Timed(name = "helloTimer", description = "A measure how long it takes to say hello.", absolute = true, unit = MetricUnits.MILLISECONDS)
    @Metered(name = "helloMeter", absolute = true)
    public String hello() throws Exception {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
//        TimeUnit.SECONDS.sleep(1);
        return "hello";
    }

}