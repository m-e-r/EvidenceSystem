package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SuspectApiService;
import io.swagger.api.factories.SuspectApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Suspect;

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

@Path("/suspect")


@io.swagger.annotations.Api(description = "the suspect API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T14:13:15.147Z")
public class SuspectApi  {
   private final SuspectApiService delegate;

   public SuspectApi(@Context ServletConfig servletContext) {
      SuspectApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SuspectApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SuspectApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SuspectApiServiceFactory.getSuspectApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets a list of suspects", notes = "Returns a list of suspects", response = Suspect.class, responseContainer = "List", tags={ "Suspect", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "list of suspects", response = Suspect.class, responseContainer = "List") })
    public Response getSuspectList(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getSuspectList(securityContext);
    }
}
