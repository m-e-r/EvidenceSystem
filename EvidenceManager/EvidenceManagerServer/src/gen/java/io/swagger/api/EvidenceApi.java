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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T09:35:04.468Z")
public class EvidenceApi  {
   private final EvidenceApiService delegate = EvidenceApiServiceFactory.getEvidenceApi();

    @GET
    @Path("/{keyWord}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Find evidence based on text", response = Evidence.class, tags={ "Evidence", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Nice find", response = Evidence.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "None match", response = Evidence.class) })
    public Response findEvidence(@ApiParam(value = "",required=true) @PathParam("keyWord") String keyWord
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findEvidence(keyWord,securityContext);
    }
}
