package io.swagger.api.impl;

import io.swagger.api.*;

import io.swagger.model.User;
import io.swagger.model.UserType;

import io.swagger.api.NotFoundException;
import io.swagger.model.Token;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import security.UserHandler;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T09:27:35.152Z")
public class UserApiServiceImpl extends UserApiService {
    private UserHandler userH;
    
    public UserApiServiceImpl() {
        this.userH = new UserHandler();
    }
    
    @Override
    public Response addUser(User user, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(this.userH.addUser(user)).build();
    }

    @Override
    public Response getListOfUsers(Token token, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        System.out.println("Fra API: " + token.getId());
        return Response.ok().entity(this.userH.getListOfUsers(token)).build();
    }
    
    @Override
    public Response getUser(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(this.userH.getUser(id)).build();
    }

    @Override
    public Response updateUser(User user, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

}
