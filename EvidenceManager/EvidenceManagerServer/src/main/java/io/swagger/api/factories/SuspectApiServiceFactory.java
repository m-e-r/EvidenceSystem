package io.swagger.api.factories;

import io.swagger.api.SuspectApiService;
import io.swagger.api.impl.SuspectApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class SuspectApiServiceFactory {
    private final static SuspectApiService service = new SuspectApiServiceImpl();

    public static SuspectApiService getSuspectApi() {
        return service;
    }
}
