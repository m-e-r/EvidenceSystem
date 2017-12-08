package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Suspect;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import security.ServerSecurity;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-14T14:01:20.310Z")
public class SuspectApiServiceImpl extends SuspectApiService {
    private Validator val;
    
    public SuspectApiServiceImpl() {
        this.val = new ServerSecurity();
        
        
    }
    @Override
    public Response getSuspectList(Token token, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        //if (this.val.callValidated(token))
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        //else
        //    return null;
    }
}
