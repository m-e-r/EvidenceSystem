package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UserGeneratorApiService;
import io.swagger.api.factories.UserGeneratorApiServiceFactory;

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

@Path("/userGenerator")


@io.swagger.annotations.Api(description = "the userGenerator API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class UserGeneratorApi  {
   private final UserGeneratorApiService delegate = UserGeneratorApiServiceFactory.getUserGeneratorApi();

    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "gets a user Id using generator", notes = "Returns user Id using generator", response = String.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Succesfully returned userId from generator", response = String.class) })
    public Response genUserId(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.genUserId(securityContext);
    }
}
