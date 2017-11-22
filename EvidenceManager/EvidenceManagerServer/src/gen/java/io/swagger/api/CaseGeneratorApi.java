package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.CaseGeneratorApiService;
import io.swagger.api.factories.CaseGeneratorApiServiceFactory;

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

@Path("/caseGenerator")


@io.swagger.annotations.Api(description = "the caseGenerator API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-22T09:15:34.527Z")
public class CaseGeneratorApi  {
   private final CaseGeneratorApiService delegate = CaseGeneratorApiServiceFactory.getCaseGeneratorApi();

    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "gets a case Id using generator", notes = "Returns case Id using generator", response = String.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully returned caseId from generator", response = String.class) })
    public Response genCaseId(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.genCaseId(securityContext);
    }
}
