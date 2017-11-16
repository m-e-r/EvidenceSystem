package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;
import security.Login;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class LoginApiServiceImpl extends LoginApiService {
    
    ILogin i;
    
    public LoginApiServiceImpl() {
        
        i = new Login();
    }
    
    @Override
    public Response doLogin(String userName, String password, SecurityContext securityContext) throws NotFoundException {
        String s = userName + ";" +password;
        return Response.ok().entity(this.i.doLogin(s)).build();
    }
}
