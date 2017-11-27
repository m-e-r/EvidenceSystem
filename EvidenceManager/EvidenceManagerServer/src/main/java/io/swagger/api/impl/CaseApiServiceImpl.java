package io.swagger.api.impl;

import Entity.CaseHandler;
import SQLImplementation.CaseHandlerSQL;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.CriminalCase;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import Entity.ICaseHandlerSQL;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:42:45.231Z")
public class CaseApiServiceImpl extends CaseApiService {
    private CaseHandler handler = new CaseHandler();
    
    @Override
    public Response addCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(handler.addCase(theCase)).build();
    }
    @Override
    public Response getCase(String caseId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(handler.getCase(Integer.parseInt(caseId))).build();
    }
    @Override
    public Response updateCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(handler.updateCase(theCase)).build();
    }
}
