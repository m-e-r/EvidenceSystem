package io.swagger.api.factories;

import io.swagger.api.SecurityApiService;
import io.swagger.api.impl.SecurityApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T14:13:15.147Z")
public class SecurityApiServiceFactory {
    private final static SecurityApiService service = new SecurityApiServiceImpl();

    public static SecurityApiService getSecurityApi() {
        return service;
    }
}
