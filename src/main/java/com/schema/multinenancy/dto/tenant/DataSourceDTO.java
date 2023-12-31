package com.schema.multinenancy.dto.tenant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataSourceDTO {

    private String schemaName;
    private String dataBaseUrl;
    private String user;
    private String password;

}