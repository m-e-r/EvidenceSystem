package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.EvidenceGeneratorApiService;
import io.swagger.api.factories.EvidenceGeneratorApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

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

@Path("/evidenceGenerator")


@io.swagger.annotations.Api(description = "the evidenceGenerator API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-08T08:55:07.282Z")
public class EvidenceGeneratorApi  {
   private final EvidenceGeneratorApiService delegate;

   public EvidenceGeneratorApi(@Context ServletConfig servletContext) {
      EvidenceGeneratorApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("EvidenceGeneratorApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (EvidenceGeneratorApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = EvidenceGeneratorApiServiceFactory.getEvidenceGeneratorApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "gets a evidence Id using generator", notes = "Returns evidence Id using generator", response = String.class, tags={ "Security", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully returned evidenceId from generator", response = String.class) })
    public Response genEvidenceId(@ApiParam(value = "" ,required=true) Token token
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.genEvidenceId(token,securityContext);
    }
}
