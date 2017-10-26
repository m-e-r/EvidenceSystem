package io.swagger.api.impl;

import dbConnection.sqlStatement;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Evidence;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T09:35:04.468Z")
public class EvidenceApiServiceImpl extends EvidenceApiService {
    
    private sqlStatement i;
    
    @Override
    public Response findEvidence(String keyWord, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(this.i.findEvidence(keyWord)).build();
    }
}
