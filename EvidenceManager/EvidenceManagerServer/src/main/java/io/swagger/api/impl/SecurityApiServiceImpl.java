package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import security.Login;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class SecurityApiServiceImpl extends SecurityApiService {
    
    ILogin i;
    
    public SecurityApiServiceImpl() {
        this.i = new Login();
    }
    
    @Override
    public Response doLogin(String userName, String password, SecurityContext securityContext) throws NotFoundException {
        String s = userName + ";" + password;
        System.out.println(this.i.doLogin(s));
        return Response.ok().entity(this.i.doLogin(s)).build();
    }
}