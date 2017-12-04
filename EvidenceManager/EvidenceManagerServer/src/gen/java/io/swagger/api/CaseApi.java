package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.CaseApiService;
import io.swagger.api.factories.CaseApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;
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

@Path("/case")


@io.swagger.annotations.Api(description = "the case API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T13:34:37.260Z")
public class CaseApi  {
   private final CaseApiService delegate;

   public CaseApi(@Context ServletConfig servletContext) {
      CaseApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("CaseApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (CaseApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = CaseApiServiceFactory.getCaseApi();
      }

      this.delegate = delegate;
   }

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
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "None match", response = Void.class) })
    public Response getCase(@ApiParam(value = "",required=true) @PathParam("caseId") String caseId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCase(caseId,securityContext);
    }
    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "gets a hashmap with caseId as key and Case name value", notes = "returns a hashmap", response = CriminalCaseMap.class, tags={ "CriminalCase", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "succesfully returned", response = CriminalCaseMap.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "noting found", response = Void.class) })
    public Response getCasesFromId(@ApiParam(value = "" ,required=true) Token user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCasesFromId(user,securityContext);
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
