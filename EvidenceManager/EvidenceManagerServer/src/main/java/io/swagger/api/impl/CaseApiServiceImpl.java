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

    
    /*
    Method for instantiating IsqlInterface
    */
    public CaseApiServiceImpl() {
        this.i = new sqlStatement();
    }
    
    /**
     * Method for adding case. Gets a case from Client, and sends a message to the database, to save it.
     * @param theCase
     * @param securityContext
     * @return boolean
     * @throws NotFoundException 
     */
    @Override
    public Response addCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        System.err.println("addCase fra caseApiImpl");
        return Response.ok().entity(this.i.addCase(theCase)).build();
    }
    
    /**
     * Gets a caseId from client, and returns a CriminalCase object from database.
     * @param caseId
     * @param securityContext
     * @return CriminalCase object
     * @throws NotFoundException 
     */
    @Override
    public Response getCase(Integer caseId, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(this.i.getCase(caseId)).build();
    }
    
    /**
     * Gets a CriminalCase from client, and sends a message to database, to save it.
     * @param CriminalCase
     * @param SecurityContext
     * @return boolean
     * @throws NotFoundException 
     */
    @Override
    public Response updateCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(this.i.updateCase(theCase)).build();
    }
}
