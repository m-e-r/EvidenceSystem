package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SecurityApi
 */
public class SecurityApiTest {

    private final SecurityApi api = new SecurityApi();

    
    /**
     * Adds a user
     *
     * adds a user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addUserTest() throws ApiException {
        User user = null;
        // Boolean response = api.addUser(user);

        // TODO: test validations
    }
    
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
        // Token response = api.doLogin(userName, password);

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
        // String response = api.genCaseId();

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
        // String response = api.genEvidenceId();

        // TODO: test validations
    }
    
    /**
     * returns a boolean depend on the enum
     *
     * returns a boolean
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendRankTest() throws ApiException {
        UserType text = null;
        // Boolean response = api.sendRank(text);

        // TODO: test validations
    }
    
}
