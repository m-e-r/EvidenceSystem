package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.LawEnforcerApiService;
import io.swagger.api.factories.LawEnforcerApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.CriminalCaseMap;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/lawEnforcer")


@io.swagger.annotations.Api(description = "the lawEnforcer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T09:27:35.152Z")
public class LawEnforcerApi  {
   private final LawEnforcerApiService delegate = LawEnforcerApiServiceFactory.getLawEnforcerApi();

    @GET
    @Path("/{employeeId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "gets a hashmap with caseId as key and Case name as value", notes = "returns a hashmap", response = CriminalCaseMap.class, tags={ "LawEnForcer", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully returned", response = CriminalCaseMap.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "noting found", response = CriminalCaseMap.class) })
    public Response getCasesFromId(@ApiParam(value = "",required=true) @PathParam("employeeId") String employeeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCasesFromId(employeeId,securityContext);
    }
}
