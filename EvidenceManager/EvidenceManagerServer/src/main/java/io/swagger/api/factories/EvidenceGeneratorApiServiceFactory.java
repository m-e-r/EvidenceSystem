package io.swagger.api.factories;

import io.swagger.api.EvidenceGeneratorApiService;
import io.swagger.api.impl.EvidenceGeneratorApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class EvidenceGeneratorApiServiceFactory {
    private final static EvidenceGeneratorApiService service = new EvidenceGeneratorApiServiceImpl();

    public static EvidenceGeneratorApiService getEvidenceGeneratorApi() {
        return service;
    }
}
