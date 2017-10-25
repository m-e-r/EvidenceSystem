package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.LogintestApiService;
import io.swagger.api.factories.LogintestApiServiceFactory;

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

@Path("/logintest")


@io.swagger.annotations.Api(description = "the logintest API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T12:17:24.322Z")
public class LogintestApi  {
   private final LogintestApiService delegate = LogintestApiServiceFactory.getLogintestApi();

    @GET
    @Path("/{userName}/{password}}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Boolean.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Boolean.class) })
    public Response findTheObject(@ApiParam(value = "",required=true) @PathParam("userName") String userName
,@ApiParam(value = "",required=true) @PathParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findTheObject(userName,password,securityContext);
    }
}
