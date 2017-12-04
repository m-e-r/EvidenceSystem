package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T14:13:15.147Z")
public abstract class CaseApiService {
    public abstract Response addCase(CriminalCase theCase,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCase(String caseId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCasesFromId(Token user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCase(CriminalCase theCase,SecurityContext securityContext) throws NotFoundException;
}
