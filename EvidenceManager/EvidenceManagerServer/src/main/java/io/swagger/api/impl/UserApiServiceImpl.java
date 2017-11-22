package io.swagger.api.impl;

import security.IUserSql;
import dbConnection.SQLStatement;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.User;
import io.swagger.model.UserType;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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
    public Response getListOfUsers(String location, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(this.userH.getUsers(location)).build();
    }
    
    @Override
    public Response getUser(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendRank(UserType text, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
