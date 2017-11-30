package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private final UserApi api = new UserApi();

    
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
     * Gets a list of the users with a location
     *
     * Returns a list of users with the location
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getListOfUsersTest() throws ApiException {
        User user = null;
        // List<User> response = api.getListOfUsers(user);

        // TODO: test validations
    }
    
    /**
     * Gets a user based on Id
     *
     * Retuns a user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUserTest() throws ApiException {
        String id = null;
        // User response = api.getUser(id);

        // TODO: test validations
    }
    
    /**
     * updates the users information
     *
     * updates a user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateUserTest() throws ApiException {
        User user = null;
        // Boolean response = api.updateUser(user);

        // TODO: test validations
    }
    
}
