package io.swagger.api.factories;

import io.swagger.api.CaseApiService;
import io.swagger.api.impl.CaseApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-22T09:15:34.527Z")
public class CaseApiServiceFactory {
    private final static CaseApiService service = new CaseApiServiceImpl();

    public static CaseApiService getCaseApi() {
        return service;
    }
}
