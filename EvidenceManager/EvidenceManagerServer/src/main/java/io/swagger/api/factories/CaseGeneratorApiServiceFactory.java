package io.swagger.api.factories;

import io.swagger.api.CaseGeneratorApiService;
import io.swagger.api.impl.CaseGeneratorApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class CaseGeneratorApiServiceFactory {
    private final static CaseGeneratorApiService service = new CaseGeneratorApiServiceImpl();

    public static CaseGeneratorApiService getCaseGeneratorApi() {
        return service;
    }
}
