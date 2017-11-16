package io.swagger.api.factories;

import io.swagger.api.EvidenceApiService;
import io.swagger.api.impl.EvidenceApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class EvidenceApiServiceFactory {
    private final static EvidenceApiService service = new EvidenceApiServiceImpl();

    public static EvidenceApiService getEvidenceApi() {
        return service;
    }
}
