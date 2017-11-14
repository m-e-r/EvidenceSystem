package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.EvidenceGeneratorApiService;
import io.swagger.api.factories.EvidenceGeneratorApiServiceFactory;

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

@Path("/evidenceGenerator")


@io.swagger.annotations.Api(description = "the evidenceGenerator API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class EvidenceGeneratorApi  {
   private final EvidenceGeneratorApiService delegate = EvidenceGeneratorApiServiceFactory.getEvidenceGeneratorApi();

    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "gets a evidence Id using generator", notes = "Returns evidence Id using generator", response = String.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully returned evidenceId from generator", response = String.class) })
    public Response genEvidenceId(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.genEvidenceId(securityContext);
    }
}
