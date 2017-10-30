package io.swagger.api.factories;

import io.swagger.api.SuspectApiService;
import io.swagger.api.impl.SuspectApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-30T16:59:45.383Z")
public class SuspectApiServiceFactory {
    private final static SuspectApiService service = new SuspectApiServiceImpl();

    public static SuspectApiService getSuspectApi() {
        return service;
    }
}
