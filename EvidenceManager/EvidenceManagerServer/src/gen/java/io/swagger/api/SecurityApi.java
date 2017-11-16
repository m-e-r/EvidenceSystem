package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SecurityApiService;
import io.swagger.api.factories.SecurityApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/security")


@io.swagger.annotations.Api(description = "the security API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class SecurityApi  {
   private final SecurityApiService delegate = SecurityApiServiceFactory.getSecurityApi();

    @POST
    @Path("/{userName}/{password}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Token.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Token.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "failed login", response = Token.class) })
    public Response doLogin(@ApiParam(value = "",required=true) @PathParam("userName") String userName
,@ApiParam(value = "",required=true) @PathParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.doLogin(userName,password,securityContext);
    }
}
