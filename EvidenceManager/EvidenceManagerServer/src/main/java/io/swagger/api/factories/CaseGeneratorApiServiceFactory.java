package io.swagger.api.factories;

import io.swagger.api.CaseGeneratorApiService;
import io.swagger.api.impl.CaseGeneratorApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T14:13:15.147Z")
public class CaseGeneratorApiServiceFactory {
    private final static CaseGeneratorApiService service = new CaseGeneratorApiServiceImpl();

    public static CaseGeneratorApiService getCaseGeneratorApi() {
        return service;
    }
}
