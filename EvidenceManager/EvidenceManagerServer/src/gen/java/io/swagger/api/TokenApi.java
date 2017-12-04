package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.TokenApiService;
import io.swagger.api.factories.TokenApiServiceFactory;

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

@Path("/token")


@io.swagger.annotations.Api(description = "the token API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T13:34:37.260Z")
public class TokenApi  {
   private final TokenApiService delegate;

   public TokenApi(@Context ServletConfig servletContext) {
      TokenApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("TokenApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (TokenApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = TokenApiServiceFactory.getTokenApi();
      }

      this.delegate = delegate;
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
}
