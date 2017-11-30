package io.swagger.api.factories;

import io.swagger.api.SuspectApiService;
import io.swagger.api.impl.SuspectApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-30T15:15:00.455Z")
public class SuspectApiServiceFactory {
    private final static SuspectApiService service = new SuspectApiServiceImpl();

    public static SuspectApiService getSuspectApi() {
        return service;
    }
}
