package io.swagger.api.factories;

import io.swagger.api.LogintestApiService;
import io.swagger.api.impl.LogintestApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T12:17:24.322Z")
public class LogintestApiServiceFactory {
    private final static LogintestApiService service = new LogintestApiServiceImpl();

    public static LogintestApiService getLogintestApi() {
        return service;
    }
}
