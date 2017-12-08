package io.swagger.api.factories;

import io.swagger.api.CaseGeneratorApiService;
import io.swagger.api.impl.CaseGeneratorApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-08T08:55:07.282Z")
public class CaseGeneratorApiServiceFactory {
    private final static CaseGeneratorApiService service = new CaseGeneratorApiServiceImpl();

    public static CaseGeneratorApiService getCaseGeneratorApi() {
        return service;
    }
}
