package io.swagger.api.factories;

import io.swagger.api.TokenApiService;
import io.swagger.api.impl.TokenApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T14:13:15.147Z")
public class TokenApiServiceFactory {
    private final static TokenApiService service = new TokenApiServiceImpl();

    public static TokenApiService getTokenApi() {
        return service;
    }
}
