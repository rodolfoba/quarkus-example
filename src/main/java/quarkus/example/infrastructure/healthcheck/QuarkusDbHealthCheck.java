package quarkus.example.infrastructure.healthcheck;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.eclipse.microprofile.health.*;

@Liveness
@ApplicationScoped
public class QuarkusDbHealthCheck implements HealthCheck {

    @Inject
    DataSource ds;
    
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder builder = HealthCheckResponse.named("quarkusdb");
        try (Connection connection = ds.getConnection()) {
            if (!connection.isValid(10)) {
                return builder.down().withData("message", "Invalid connection").build();
            }
        } catch (SQLException e) {
            return builder.down().withData("message", e.getMessage()).build();
        }
        
        return builder.up().build();
    }

}
