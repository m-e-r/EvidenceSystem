package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;
import io.swagger.model.Token;
import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
import security.ServerSecurity;
import security.UserHandler;
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T09:27:35.152Z")
public class UserApiServiceImpl extends UserApiService {
    private UserHandler userH;
    private Validator val;
    
    public UserApiServiceImpl() {
        this.userH = new UserHandler();
        this.val = new ServerSecurity();
    }
    
    @Override
    public Response addUser(User user, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        
        System.out.println("API USERNAME : " + user.getUsername());
        try {
            Token token = user.getToken();
            token.toString();
        } catch (NullPointerException ne) {
            System.out.println("Null token caught!");
            return Response.ok().entity(false).build();
        }
        if (this.val.callValidated(user.getToken()))
            return Response.ok().entity(this.userH.addUser(user)).build();
        else
            return Response.ok().entity(false).build();
    }

    
    @Override
    public Response getUser(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        //if (this.val.callValidated(token))
            return Response.ok().entity(this.userH.getUser(id)).build();
        //else
        //    return null;
    }

    @Override
    public Response updateUser(User user, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        try {
            Token token = user.getToken();
            token.toString();
        } catch (NullPointerException ne) {
            System.out.println("Null token caught!");
            return Response.ok().entity(false).build();
        }
        
        if (this.val.callValidated(user.getToken()))
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        else
            return Response.ok().entity(false).build();
    }

}
