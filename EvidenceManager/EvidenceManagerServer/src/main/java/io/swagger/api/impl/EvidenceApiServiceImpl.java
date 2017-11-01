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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-27T11:21:19.158Z")
public class EvidenceApiServiceImpl extends EvidenceApiService {
     
    private IsqlStatement i;
    
    /*
    Instantiate sqlStatement interface
    */
    public EvidenceApiServiceImpl(){
        this.i = new sqlStatement();
    }
    
    /**
     * Gets a keyword from client, and returns a list of Evidence.
     * @param keyword
     * @param securityContext
     * @return List<Evidence>
     * @throws NotFoundException 
     */
    @Override
    public Response getEvidenceList(String keyword, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
