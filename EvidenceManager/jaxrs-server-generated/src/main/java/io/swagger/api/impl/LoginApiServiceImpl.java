package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T09:35:04.468Z")
public class LoginApiServiceImpl extends LoginApiService {
    @Override
    public Response doLogin(String userName, String password, SecurityContext securityContext) throws NotFoundException {
    	System.out.println("What");
        boolean ans;
    	if (userName.equals("Jacob") && password.equals("password")) {
    		ans = true;
    	} else {
    		ans = false;
    	}
        // do some magic!
        return Response.ok().entity(ans).build();
    }
}
