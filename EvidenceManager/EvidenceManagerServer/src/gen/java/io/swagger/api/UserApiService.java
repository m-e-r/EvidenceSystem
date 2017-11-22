package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.User;
import io.swagger.model.UserType;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-22T09:15:34.527Z")
public abstract class UserApiService {
    public abstract Response addUser(User user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getListOfUsers(String location,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUser(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendRank(UserType text,SecurityContext securityContext) throws NotFoundException;
}
