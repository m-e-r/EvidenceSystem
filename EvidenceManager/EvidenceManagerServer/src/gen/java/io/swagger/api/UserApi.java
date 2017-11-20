package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UserApiService;
import io.swagger.api.factories.UserApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.User;
import io.swagger.model.UserType;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/user")


@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T09:27:35.152Z")
public class UserApi  {
   private final UserApiService delegate = UserApiServiceFactory.getUserApi();

    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Adds a user", notes = "adds a user", response = Boolean.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully added", response = Boolean.class) })
    public Response addUser(@ApiParam(value = "" ,required=true) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUser(user,securityContext);
    }
    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "returns a boolean depend on the enum", notes = "returns a boolean", response = Boolean.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Boolean.class) })
    public Response sendRank(@ApiParam(value = "" ,required=true) UserType text
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendRank(text,securityContext);
    }
}
