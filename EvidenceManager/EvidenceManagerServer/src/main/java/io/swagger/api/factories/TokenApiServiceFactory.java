package io.swagger.api.factories;

import io.swagger.api.TokenApiService;
import io.swagger.api.impl.TokenApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T13:34:37.260Z")
public class TokenApiServiceFactory {
    private final static TokenApiService service = new TokenApiServiceImpl();

    public static TokenApiService getTokenApi() {
        return service;
    }
}
