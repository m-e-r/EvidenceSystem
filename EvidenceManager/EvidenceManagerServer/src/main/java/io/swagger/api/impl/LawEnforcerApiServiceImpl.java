package io.swagger.api.impl;

import dbConnection.sqlStatement;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.CriminalCaseMap;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:42:45.231Z")
public class LawEnforcerApiServiceImpl extends LawEnforcerApiService {
    
    private IsqlStatement is;
    
    public LawEnforcerApiServiceImpl() {
        is = new sqlStatement();
    }
    
    @Override
    public Response getCasesFromId(String employeeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(this.is.getCases(employeeId)).build();
    }
}
