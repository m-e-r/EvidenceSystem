package io.swagger.api.factories;

import io.swagger.api.SecurityApiService;
import io.swagger.api.impl.SecurityApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-30T15:15:00.455Z")
public class SecurityApiServiceFactory {
    private final static SecurityApiService service = new SecurityApiServiceImpl();

    public static SecurityApiService getSecurityApi() {
        return service;
    }
}
