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
        Token token = theCase.getToken();
        
        //First, check for null
        try {    
            token.toString(); 
        } catch (NullPointerException ne) {             
            return Response.ok().entity(false).build();
        }
        
        //Second, check for valid token
        if (this.val.callValidated(token)) {
            System.out.println("Case: " + theCase.getCaseName() + " - with ID: " + theCase.getId() + " was added.");
            return Response.ok().entity(this.handler.addCase(theCase)).build();
        }
        
        return Response.ok().entity(false).build();
    }
    @Override
    public Response getCase(String caseId, Token token, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        //if (this.val.callValidated(token))
            CriminalCase theCase = this.handler.getCase(caseId);
            System.out.println("Fetching case: " + theCase.getCaseName() + " - with ID: " + theCase.getId());
            return Response.ok().entity(this.handler.getCase(caseId)).build();
        //else
        //    return null;
    }
    @Override
    public Response updateCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        
        try {
            Token token = theCase.getToken();
            token.toString();
        } catch (NullPointerException ne) {
             
            return Response.ok().entity(false).build();
        }
        
        if (this.val.callValidated(theCase.getToken())) {
            System.out.println("Updated case with ID: " + theCase.getId());
            return Response.ok().entity(this.handler.updateCase(theCase)).build();
        }
        else
            return Response.ok().entity(false).build();
    }
    @Override
    public Response getCasesFromId(Token token, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        
        try {
            token.toString();
        } catch (NullPointerException ne) {
             
            return Response.ok().entity(false).build();
        }
        
        if (this.val.callValidated(token)) {
            System.out.println("Fetching cases relevant for employeeID: " + token.getId());
            return Response.ok().entity(this.handler.getCases(token.getId())).build();
        }
        
        else
            return null;
    }
}
