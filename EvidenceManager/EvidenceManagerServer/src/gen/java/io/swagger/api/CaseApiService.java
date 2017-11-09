package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.CriminalCase;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-09T12:37:12.952Z")
public abstract class CaseApiService {
    public abstract Response addCase(CriminalCase theCase,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCase(Integer caseId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCase(CriminalCase theCase,SecurityContext securityContext) throws NotFoundException;
}
