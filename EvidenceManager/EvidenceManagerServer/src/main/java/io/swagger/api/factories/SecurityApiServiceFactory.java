package io.swagger.api.factories;

import io.swagger.api.SecurityApiService;
import io.swagger.api.impl.SecurityApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class SecurityApiServiceFactory {
    private final static SecurityApiService service = new SecurityApiServiceImpl();

    public static SecurityApiService getSecurityApi() {
        return service;
    }
}
