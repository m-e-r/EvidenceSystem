package io.swagger.api.factories;

import io.swagger.api.EvidenceApiService;
import io.swagger.api.impl.EvidenceApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T13:34:37.260Z")
public class EvidenceApiServiceFactory {
    private final static EvidenceApiService service = new EvidenceApiServiceImpl();

    public static EvidenceApiService getEvidenceApi() {
        return service;
    }
}
