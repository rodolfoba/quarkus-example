package quarkus.example.infrastructure.flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class MigrationService {

    @ConfigProperty(name = "quarkus.datasource.url") 
    String dbURL;
    @ConfigProperty(name = "quarkus.datasource.username")
    String dbUser;
    @ConfigProperty(name = "quarkus.datasource.password")
    String dbPassword;

    public void migrate(@Observes StartupEvent ev) {
        Flyway flyway = Flyway.configure()
                        .dataSource(dbURL, dbUser, dbPassword)
                        .load(); 
        flyway.migrate();
    }
    
}
