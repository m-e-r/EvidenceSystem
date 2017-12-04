package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SecurityApiService;
import io.swagger.api.factories.SecurityApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Token;
import io.swagger.model.User;
import io.swagger.model.UserType;

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

@Path("/security")


@io.swagger.annotations.Api(description = "the security API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T13:34:37.260Z")
public class SecurityApi  {
   private final SecurityApiService delegate;

   public SecurityApi(@Context ServletConfig servletContext) {
      SecurityApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SecurityApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SecurityApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SecurityApiServiceFactory.getSecurityApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/{userName}/{password}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Token.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Token.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "failed login", response = Void.class) })
    public Response doLogin(@ApiParam(value = "",required=true) @PathParam("userName") String userName
,@ApiParam(value = "",required=true) @PathParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.doLogin(userName,password,securityContext);
    }
    @PUT
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Send a rank", notes = "returns a boolean", response = Boolean.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Boolean.class) })
    public Response sendRank(@ApiParam(value = "" ,required=true) UserType text
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendRank(text,securityContext);
    }
    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "a commissioner validates a user", notes = "validates a user", response = Boolean.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully validated", response = Boolean.class) })
    public Response validateUser(@ApiParam(value = "" ,required=true) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.validateUser(user,securityContext);
    }
}
