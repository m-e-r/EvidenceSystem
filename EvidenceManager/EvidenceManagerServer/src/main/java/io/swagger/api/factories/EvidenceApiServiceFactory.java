package io.swagger.api.factories;

import io.swagger.api.EvidenceApiService;
import io.swagger.api.impl.EvidenceApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-30T16:59:45.383Z")
public class EvidenceApiServiceFactory {
    private final static EvidenceApiService service = new EvidenceApiServiceImpl();

    public static EvidenceApiService getEvidenceApi() {
        return service;
    }
}
