package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UserApiService;
import io.swagger.api.factories.UserApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Token;
import io.swagger.model.User;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/user")


@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-30T15:15:00.455Z")
public class UserApi  {
   private final UserApiService delegate;

   public UserApi(@Context ServletConfig servletContext) {
      UserApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("UserApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (UserApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = UserApiServiceFactory.getUserApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Adds a user", notes = "adds a user", response = Boolean.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully added", response = Boolean.class) })
    public Response addUser(@ApiParam(value = "" ,required=true) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUser(user,securityContext);
    }
    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets a list of the users with a location", notes = "Returns a list of users with the location", response = User.class, responseContainer = "List", tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "List of users", response = User.class, responseContainer = "List") })
    public Response getListOfUsers(@ApiParam(value = "" ,required=true) Token token
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getListOfUsers(token,securityContext);
    }
    @GET
    @Path("/{Id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets a user based on Id", notes = "Retuns a user", response = User.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully returned", response = User.class) })
    public Response getUser(@ApiParam(value = "",required=true) @PathParam("Id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUser(id,securityContext);
    }
    @PUT
    
    
    
    @io.swagger.annotations.ApiOperation(value = "updates the users information", notes = "updates a user", response = Boolean.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "returned", response = Boolean.class) })
    public Response updateUser(@ApiParam(value = "" ,required=true) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateUser(user,securityContext);
    }
}
