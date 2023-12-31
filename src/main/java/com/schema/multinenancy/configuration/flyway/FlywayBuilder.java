package com.schema.multinenancy.configuration.flyway;


import com.schema.multinenancy.dto.tenant.DataSourceDTO;
import com.schema.multinenancy.dto.tenant.TenantDTO;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
public class FlywayBuilder {

    private static final String DEFAULT_SCHEMA_LOCATION = "db/migration/default";
    private static final String TENANT_SCHEMA_LOCATION = "db/migration/tenants";

    private final DataSource dataSource;

    Flyway createFlyway(String schemaName) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations(DEFAULT_SCHEMA_LOCATION)
                .schemas(schemaName)
                .load();
    }

    public Boolean createFlyway(List<String> tenants) {
        tenants.forEach(tenant -> {
            Flyway flyway = Flyway.configure()
                    .dataSource(dataSource)
                    .locations(TENANT_SCHEMA_LOCATION)
                    .schemas(tenant)
                    .load();
            flyway.migrate();
        });
        return true;
    }

    private String getSchemaName(TenantDTO tenant) {
        return Optional.ofNullable(tenant)
                .map(TenantDTO::getDataSource)
                .map(DataSourceDTO::getSchemaName)
                .orElseThrow(() -> new RuntimeException("tenant model without schema name"));
    }

}
