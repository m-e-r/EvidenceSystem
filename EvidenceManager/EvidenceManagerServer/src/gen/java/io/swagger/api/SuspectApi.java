package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SuspectApiService;
import io.swagger.api.factories.SuspectApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Suspect;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/suspect")


@io.swagger.annotations.Api(description = "the suspect API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class SuspectApi  {
   private final SuspectApiService delegate = SuspectApiServiceFactory.getSuspectApi();

    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets a list of suspects", notes = "Returns a list of suspects", response = Suspect.class, responseContainer = "List", tags={ "Suspect", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "list of suspects", response = Suspect.class, responseContainer = "List") })
    public Response getSuspectList(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getSuspectList(securityContext);
    }
}
