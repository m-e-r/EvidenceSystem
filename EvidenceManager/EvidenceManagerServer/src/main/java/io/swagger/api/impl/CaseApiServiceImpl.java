package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.CriminalCase;
import io.swagger.api.NotFoundException;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T09:35:04.468Z")
public class CaseApiServiceImpl extends CaseApiService {
    
    private IsqlStatement i;
    
    @Override
    public Response addCase(CriminalCase theCase, SecurityContext securityContext) throws NotFoundException {
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
