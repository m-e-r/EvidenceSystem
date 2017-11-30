package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Token;
import io.swagger.model.User;
import io.swagger.model.UserType;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-30T15:15:00.455Z")
public abstract class SecurityApiService {
    public abstract Response doLogin(String userName,String password,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendRank(UserType text,SecurityContext securityContext) throws NotFoundException;
    public abstract Response validateUser(User user,SecurityContext securityContext) throws NotFoundException;
}
