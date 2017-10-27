package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Evidence;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-27T11:21:19.158Z")
public class EvidenceApiServiceImpl extends EvidenceApiService {
     
    private IsqlStatement i;
    
    @Override
    public Response findEvidence(String keyWord, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(this.i.findEvidence(keyWord)).build();
    }
    
    @Override
    public Response getEvidenceList(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
