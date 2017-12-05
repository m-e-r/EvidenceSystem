package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import security.IdGenerator;
import security.ServerSecurity;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class CaseGeneratorApiServiceImpl extends CaseGeneratorApiService {
    private IdGenerator gen;
    private Validator val;
    
    public CaseGeneratorApiServiceImpl() {
        this.gen = new IdGenerator();
        this.val = new ServerSecurity();
    }
    
    @Override
    public Response genCaseId(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        //if (this.val.callValidated(token))
            return Response.ok().entity(this.gen.generateCaseId()).build();
        //else
        //    return null;
    }
}
