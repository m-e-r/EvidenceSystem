package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SecurityApi
 */
@Ignore
public class SecurityApiTest {

    private final SecurityApi api = new SecurityApi();

    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void doLoginTest() throws ApiException {
        String userName = null;
        String password = null;
        Token response = api.doLogin(userName, password);

        // TODO: test validations
    }
    
    /**
     * gets a case Id using generator
     *
     * Returns case Id using generator
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void genCaseIdTest() throws ApiException {
        Token token = null;
        String response = api.genCaseId(token);

        // TODO: test validations
    }
    
    /**
     * gets a evidence Id using generator
     *
     * Returns evidence Id using generator
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void genEvidenceIdTest() throws ApiException {
        Token token = null;
        String response = api.genEvidenceId(token);

        // TODO: test validations
    }
    
    /**
     * Send a rank
     *
     * returns a boolean
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendRankTest() throws ApiException {
        UserType text = null;
        Boolean response = api.sendRank(text);

        // TODO: test validations
    }
    
    /**
     * a commissioner validates a user
     *
     * validates a user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateUserTest() throws ApiException {
        User user = null;
        Boolean response = api.validateUser(user);

        // TODO: test validations
    }
    
}
