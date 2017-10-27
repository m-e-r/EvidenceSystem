package io.swagger.api.impl;

import dbConnection.sqlStatement;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.CriminalCase;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-27T11:21:19.158Z")
public class CaseApiServiceImpl extends CaseApiService {
    private IsqlStatement i;

    
    
    public CaseApiServiceImpl() {
        this.i = new sqlStatement();
    }


    @Override
    public Response addCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        System.err.println("addCase fra caseApiImpl");
        return Response.ok().entity(this.i.addCase(theCase)).build();
    }
    
    @Override
    public Response getCase(Integer caseId, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(this.i.getCase(caseId)).build();
    }
    
    @Override
    public Response updateCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(this.i.updateCase(theCase)).build();
    }
}
