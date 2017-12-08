package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Evidence;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-08T08:55:07.282Z")
public abstract class EvidenceApiService {
    public abstract Response getEvidenceList(Token token,SecurityContext securityContext) throws NotFoundException;
    public abstract Response pickUpEvidence(Evidence evidence,String userId,SecurityContext securityContext) throws NotFoundException;
}
