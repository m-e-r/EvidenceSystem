package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.CriminalCaseMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for LawEnForcerApi
 */
public class LawEnForcerApiTest {

    private final LawEnForcerApi api = new LawEnForcerApi();

    
    /**
     * gets a hashmap with caseId as key and Case name as value
     *
     * returns a hashmap
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCasesFromIdTest() throws ApiException {
        String employeeId = null;
        // CriminalCaseMap response = api.getCasesFromId(employeeId);

        // TODO: test validations
    }
    
}
