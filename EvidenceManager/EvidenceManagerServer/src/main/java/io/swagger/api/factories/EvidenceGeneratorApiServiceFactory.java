package io.swagger.api.factories;

import io.swagger.api.EvidenceGeneratorApiService;
import io.swagger.api.impl.EvidenceGeneratorApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T14:13:15.147Z")
public class EvidenceGeneratorApiServiceFactory {
    private final static EvidenceGeneratorApiService service = new EvidenceGeneratorApiServiceImpl();

    public static EvidenceGeneratorApiService getEvidenceGeneratorApi() {
        return service;
    }
}
