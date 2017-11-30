package io.swagger.api.factories;

import io.swagger.api.EvidenceApiService;
import io.swagger.api.impl.EvidenceApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-30T15:15:00.455Z")
public class EvidenceApiServiceFactory {
    private final static EvidenceApiService service = new EvidenceApiServiceImpl();

    public static EvidenceApiService getEvidenceApi() {
        return service;
    }
}
