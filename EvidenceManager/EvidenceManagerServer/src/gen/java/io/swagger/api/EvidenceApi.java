package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.EvidenceApiService;
import io.swagger.api.factories.EvidenceApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Evidence;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/evidence")


@io.swagger.annotations.Api(description = "the evidence API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-22T09:15:34.527Z")
public class EvidenceApi  {
   private final EvidenceApiService delegate = EvidenceApiServiceFactory.getEvidenceApi();

    @GET
    @Path("/{keyword}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets a list of Evidence", notes = "Returns a list of Evidence", response = Evidence.class, responseContainer = "List", tags={ "Evidence", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "list of Evidence", response = Evidence.class, responseContainer = "List") })
    public Response getEvidenceList(@ApiParam(value = "",required=true) @PathParam("keyword") String keyword
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getEvidenceList(keyword,securityContext);
    }
}
