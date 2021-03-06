package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Suspect;
import io.swagger.client.model.Token;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SuspectApi
 */
@Ignore
public class SuspectApiTest {

    private final SuspectApi api = new SuspectApi();

    
    /**
     * Gets a list of suspects
     *
     * Returns a list of suspects
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSuspectListTest() throws ApiException {
        Token token = null;
        List<Suspect> response = api.getSuspectList(token);

        // TODO: test validations
    }
    
}
