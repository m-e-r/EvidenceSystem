package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Token;
import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-11T15:21:50.003Z")
public abstract class UserApiService {
    public abstract Response addUser(User user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUser(String id,Token token,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUser(User user,SecurityContext securityContext) throws NotFoundException;
}
