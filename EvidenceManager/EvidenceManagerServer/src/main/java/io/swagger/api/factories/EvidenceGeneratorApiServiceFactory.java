package io.swagger.api.factories;

import io.swagger.api.EvidenceGeneratorApiService;
import io.swagger.api.impl.EvidenceGeneratorApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class EvidenceGeneratorApiServiceFactory {
    private final static EvidenceGeneratorApiService service = new EvidenceGeneratorApiServiceImpl();

    public static EvidenceGeneratorApiService getEvidenceGeneratorApi() {
        return service;
    }
}
