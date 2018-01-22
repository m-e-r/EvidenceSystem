package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import security.Login;
import security.ServerSecurity;
import security.UserHandler;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-16T11:40:25.777Z")
public class SecurityApiServiceImpl extends SecurityApiService {
    
    private ILogin i;
    private UserHandler userH;
    private Validator val;
    
    public SecurityApiServiceImpl() {
        this.i = new Login();
        this.userH = new UserHandler();
        this.val = new ServerSecurity();
    }
    
    @Override
    public Response doLogin(String userName, String password, SecurityContext securityContext) throws NotFoundException {
        String s = userName + ";" + password;
        Token result = this.i.doLogin(s);

        return Response.ok().entity(result).build();
    }

    @Override
    public Response validateUser(User user, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        try {
            Token token = user.getToken();
            token.toString();
        } catch (NullPointerException ne) {
             
            return Response.ok().entity(false).build();
        }
        if (this.val.callValidated(user.getToken())) {
            System.out.println("Successfully validated user with ID: " + user.getEmployeeId());
            return Response.ok().entity(this.userH.validateUser(user)).build();
        }
        else
            return Response.ok().entity(false).build();
    }

    @Override
    public Response sendRank(UserType text, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        
        //WHAT Sender userType virker det???? nok IKKKE. FIKS DET HER
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
