package com.schema.multinenancy.configuration.hibernate.multitenancy;

public class ConnectionProviderException extends RuntimeException{

    public ConnectionProviderException(String message) {
        super(message);
    }
}