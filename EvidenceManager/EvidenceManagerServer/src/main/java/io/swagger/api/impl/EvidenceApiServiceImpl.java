package io.swagger.api.impl;

import Entity.EvidenceHandler;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Evidence;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class EvidenceApiServiceImpl extends EvidenceApiService {
    
    private EvidenceHandler handler = new EvidenceHandler();
    
    @Override
    public Response getEvidenceList(String keyword, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(handler.getEvidenceList(keyword)).build();
    }
}
