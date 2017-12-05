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
import security.ServerSecurity;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:42:45.231Z")
public class CaseApiServiceImpl extends CaseApiService {
    private CaseHandler handler;
    private Validator val;
    
    public CaseApiServiceImpl() {
        this.handler = new CaseHandler();
        this.val = new ServerSecurity();
    }
    
    @Override
    public Response addCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        if (this.val.callValidated(theCase.getToken()))
            return Response.ok().entity(this.handler.addCase(theCase)).build();
        else
            return Response.ok().entity(false).build();
    }
    @Override
    public Response getCase(String caseId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        //if (this.val.callValidated(token))
            return Response.ok().entity(this.handler.getCase(caseId)).build();
        //else
        //    return null;
    }
    @Override
    public Response updateCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        if (this.val.callValidated(theCase.getToken()))
            return Response.ok().entity(this.handler.updateCase(theCase)).build();
        else
            return Response.ok().entity(false).build();
    }
    @Override
    public Response getCasesFromId(Token token, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        if (this.val.callValidated(token))
            return Response.ok().entity(this.handler.getCases(token.getId())).build();
        else
            return null;
    }
}
