package io.swagger.api.impl;

import dbConnection.SQLStatement;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.CriminalCase;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:42:45.231Z")
public class CaseApiServiceImpl extends CaseApiService {
    private IsqlStatement sql = new SQLStatement();
    
    @Override
    public Response addCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(sql.addCase(theCase)).build();
    }
    @Override
    public Response getCase(String caseId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(sql.getCase(Integer.parseInt(caseId))).build();
    }
    @Override
    public Response updateCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(sql.updateCase(theCase)).build();
    }
}
