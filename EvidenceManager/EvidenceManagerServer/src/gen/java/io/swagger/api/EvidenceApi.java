package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.EvidenceApiService;
import io.swagger.api.factories.EvidenceApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Evidence;
import io.swagger.model.Token;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/evidence")


@io.swagger.annotations.Api(description = "the evidence API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-08T08:55:07.282Z")
public class EvidenceApi  {
   private final EvidenceApiService delegate;

   public EvidenceApi(@Context ServletConfig servletContext) {
      EvidenceApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("EvidenceApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (EvidenceApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = EvidenceApiServiceFactory.getEvidenceApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/{userId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets a list of Evidence", notes = "Returns a list of Evidence", response = Evidence.class, responseContainer = "List", tags={ "Evidence", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "list of Evidence", response = Evidence.class, responseContainer = "List") })
    public Response getEvidenceList(@ApiParam(value = "" ,required=true) Token token
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getEvidenceList(token,securityContext);
    }
    @PUT
    @Path("/{userId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "pick up evidence", notes = "pick up evidence", response = Boolean.class, tags={ "Evidence", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully picked up", response = Boolean.class) })
    public Response pickUpEvidence(@ApiParam(value = "" ,required=true) Evidence evidence
,@ApiParam(value = "",required=true) @PathParam("userId") String userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.pickUpEvidence(evidence,userId,securityContext);
    }
}
