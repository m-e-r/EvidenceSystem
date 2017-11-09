package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.LoginApiService;
import io.swagger.api.factories.LoginApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/login")


@io.swagger.annotations.Api(description = "the login API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-09T12:37:12.952Z")
public class LoginApi  {
   private final LoginApiService delegate = LoginApiServiceFactory.getLoginApi();

    @POST
    @Path("/{userName}/{password}}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Integer.class, tags={ "Login", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Integer.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "failed login", response = Integer.class) })
    public Response doLogin(@ApiParam(value = "",required=true) @PathParam("userName") String userName
,@ApiParam(value = "",required=true) @PathParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.doLogin(userName,password,securityContext);
    }
}
