package io.swagger.api.factories;

import io.swagger.api.SecurityApiService;
import io.swagger.api.impl.SecurityApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T09:27:35.152Z")
public class SecurityApiServiceFactory {
    private final static SecurityApiService service = new SecurityApiServiceImpl();

    public static SecurityApiService getSecurityApi() {
        return service;
    }
}
