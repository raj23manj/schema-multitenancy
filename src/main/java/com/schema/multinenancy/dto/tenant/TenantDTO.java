package com.schema.multinenancy.dto.tenant;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class TenantDTO {

    private String tenantId;
    private DataSourceDTO dataSource;

}