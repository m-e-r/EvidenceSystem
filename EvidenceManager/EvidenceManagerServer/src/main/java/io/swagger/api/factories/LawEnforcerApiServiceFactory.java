package io.swagger.api.factories;

import io.swagger.api.LawEnforcerApiService;
import io.swagger.api.impl.LawEnforcerApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:42:45.231Z")
public class LawEnforcerApiServiceFactory {
    private final static LawEnforcerApiService service = new LawEnforcerApiServiceImpl();

    public static LawEnforcerApiService getLawEnforcerApi() {
        return service;
    }
}
