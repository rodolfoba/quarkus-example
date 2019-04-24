package quarkus.example.infrastructure.jpa;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

@Health
@ApplicationScoped
public class JpaHealthCheck implements HealthCheck {

    @Inject
    DataSource ds;
    
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder builder = HealthCheckResponse.named("postgres");
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
