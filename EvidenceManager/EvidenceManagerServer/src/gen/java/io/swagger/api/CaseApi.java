package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.CaseApiService;
import io.swagger.api.factories.CaseApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.CriminalCase;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/case")


@io.swagger.annotations.Api(description = "the case API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-22T09:15:34.527Z")
public class CaseApi  {
   private final CaseApiService delegate = CaseApiServiceFactory.getCaseApi();

    @POST
    @Path("/{caseId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Adds a case", response = Boolean.class, tags={ "CriminalCase", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "All good", response = Boolean.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Oh no!", response = Boolean.class) })
    public Response addCase(@ApiParam(value = "" ,required=true) CriminalCase theCase
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addCase(theCase,securityContext);
    }
    @GET
    @Path("/{caseId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets a case", response = CriminalCase.class, tags={ "CriminalCase", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Succesfully returned", response = CriminalCase.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "None match", response = CriminalCase.class) })
    public Response getCase(@ApiParam(value = "",required=true) @PathParam("caseId") String caseId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCase(caseId,securityContext);
    }
    @PUT
    @Path("/{caseId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Updates a case", response = Boolean.class, tags={ "CriminalCase", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Fine", response = Boolean.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something is wrong", response = Boolean.class) })
    public Response updateCase(@ApiParam(value = "" ,required=true) CriminalCase theCase
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCase(theCase,securityContext);
    }
}
