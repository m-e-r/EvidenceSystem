package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Token;
import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.util.Date;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
import security.ServerSecurity;
import security.UserHandler;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T13:34:37.260Z")
public class TokenApiServiceImpl extends TokenApiService {

    private UserHandler userH;
    private Validator val;

    public TokenApiServiceImpl() {
    	this.userH = new UserHandler();
        this.val = new ServerSecurity();
    }

    @Override
    public Response getListOfUsers(Token token, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        
        try {
            token.toString();
        } catch (NullPointerException ne) {
             
            return Response.ok().entity(false).build();
        }
        
        if (this.val.callValidated(token)) {   
            return Response.ok().entity(this.userH.getListOfUsers(token)).build();
        }
        return null;
    }
}
