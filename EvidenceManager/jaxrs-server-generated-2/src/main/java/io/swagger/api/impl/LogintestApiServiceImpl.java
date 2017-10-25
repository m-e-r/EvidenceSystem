package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T12:17:24.322Z")
public class LogintestApiServiceImpl extends LogintestApiService {
    @Override
    public Response findTheObject(String userName, String password, SecurityContext securityContext) throws NotFoundException {
        
        // do some magic!
        boolean what;
        if (userName.equals("Jacob") && password.equals("kodeord")) {
        	System.out.println("Good job");
        	what = true;
        } else {
        	System.out.println("Sorry no access");
        	what = false;
        }
        return Response.ok().entity(what).build();
    }
}
