package io.swagger.api.factories;

import io.swagger.api.UserGeneratorApiService;
import io.swagger.api.impl.UserGeneratorApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class UserGeneratorApiServiceFactory {
    private final static UserGeneratorApiService service = new UserGeneratorApiServiceImpl();

    public static UserGeneratorApiService getUserGeneratorApi() {
        return service;
    }
}
