package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.api.NotFoundException;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T09:35:04.468Z")
public class EvidenceApiServiceImpl extends EvidenceApiService {
    
    private IsqlStatement i;
    
    @Override
    public Response findEvidence(String keyWord, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(this.i.findEvidence(keyWord)).build();
    }
}
