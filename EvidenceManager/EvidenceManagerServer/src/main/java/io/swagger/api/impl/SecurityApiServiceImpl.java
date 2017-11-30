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
import security.UserHandler;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class SecurityApiServiceImpl extends SecurityApiService {
    
    ILogin i;
    UserHandler userH;
    
    public SecurityApiServiceImpl() {
        this.i = new Login();
        this.userH = new UserHandler();
    }
    
    @Override
    public Response doLogin(String userName, String password, SecurityContext securityContext) throws NotFoundException {
        String s = userName + ";" + password;
        return Response.ok().entity(this.i.doLogin(s)).build();
    }

    @Override
    public Response validateUser(User user, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(this.userH.validateUser(user)).build();
    }

    @Override
    public Response sendRank(UserType text, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
