package io.swagger.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T12:17:24.322Z")
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
