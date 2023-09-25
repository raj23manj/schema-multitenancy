package com.schema.multinenancy.configuration.flyway;

import javax.sql.DataSource;

import com.schema.multinenancy.configuration.multitenancy.context.TenantContext;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;


@Configuration
public class FlywayConfiguration {

    private final String flywayUrl;
    private final String flywayUser;
    private final String flywayPassword;
    private final String flywayDriver;

    DataSource dataSource;

    public FlywayConfiguration(DataSource dataSource,
                               @Value("${flyway.url}") String flywayUrl,
                               @Value("${flyway.user}") String flywayUser,
                               @Value("${flyway.password}") String flywayPassword,
                               @Value("${spring.datasource.driverClassName}") String flywayDriver) {
        this.flywayUrl = flywayUrl;
        this.flywayUser = flywayUser;
        this.flywayPassword = flywayPassword;
        this.flywayDriver = flywayDriver;
        this.dataSource = dataSource;
    }

    @Bean
    FlywayBuilder flywayBuilder() {
        return new FlywayBuilder(dataSource);
    }

    @Bean
    Flyway flyway() {
        Flyway flyway = flywayBuilder().createFlyway(TenantContext.DEFAULT_TENANT_ID);
        flyway.migrate();
        return flyway;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            /*
            getAllTenants().forEach(tenant -> {
                Flyway flyway = flywayBuilder().createFlyway(tenant);
                flyway.migrate();
            });
            */
            flywayBuilder().createFlyway(getAllTenants());

        };
    }

    private List<String> getAllTenants() {
        return Arrays.asList(
                "tenant1",
                "tenant2"
        );
    }

}