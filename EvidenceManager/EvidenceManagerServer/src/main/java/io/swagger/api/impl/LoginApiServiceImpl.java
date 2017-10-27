package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-27T11:21:19.158Z")
public class LoginApiServiceImpl extends LoginApiService {
    private int count;
    @Override
    public Response doLogin(String userName, String password, SecurityContext securityContext) throws NotFoundException {
    	//First couple of lines just for testing...
        System.out.println("What " + this.count);
        this.count++;
        

        boolean ans;

        //Expected input if the user has left the textfields in the client empty
        if (userName.equals(" ") || password.equals(" ")) {
            ans = false;

        //Else, check if user has acces    
    	} else if (userName.equals("Jacob") && password.equals("password")) {
    		ans = true;
    	} else {
    		ans = false;
    	}
        // do some magic!
        return Response.ok().entity(ans).build();
    }
}
