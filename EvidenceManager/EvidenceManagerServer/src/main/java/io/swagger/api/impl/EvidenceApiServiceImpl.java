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
import security.ServerSecurity;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class EvidenceApiServiceImpl extends EvidenceApiService {
    
    private EvidenceHandler handler;
    private Validator val;
    
    public EvidenceApiServiceImpl() {
        this.handler = new EvidenceHandler();
        this.val = new ServerSecurity();
    }
    
    @Override
    public Response getEvidenceList(Token token, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        try {
            token.toString();
        } catch (NullPointerException ne) {
             
            return Response.ok().entity(false).build();
        }
        
        if (this.val.callValidated(token))
            return Response.ok().entity(this.handler.getEvidenceList(token.getId())).build();
        else
            return null;
    }

    @Override
    public Response pickUpEvidence(Evidence evidence, String userId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        try {
            Token token = evidence.getToken();
            token.toString();
        } catch (NullPointerException ne) {
             
            return Response.ok().entity(false).build();
        }
        
        if (this.val.callValidated(evidence.getToken()))
            return Response.ok().entity(this.handler.pickupEvidence(evidence, userId)).build();
        else
            return Response.ok().entity(false).build();
    }
}
