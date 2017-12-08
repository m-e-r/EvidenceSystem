package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.CriminalCaseMap;
import io.swagger.client.model.Token;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CriminalCaseApi
 */
@Ignore
public class CriminalCaseApiTest {

    private final CriminalCaseApi api = new CriminalCaseApi();

    
    /**
     * 
     *
     * Adds a case
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addCaseTest() throws ApiException {
        CriminalCase theCase = null;
        Boolean response = api.addCase(theCase);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Gets a case
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCaseTest() throws ApiException {
        String caseId = null;
        Token token = null;
        CriminalCase response = api.getCase(caseId, token);

        // TODO: test validations
    }
    
    /**
     * gets a hashmap with caseId as key and Case name value
     *
     * returns a hashmap
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCasesFromIdTest() throws ApiException {
        Token user = null;
        CriminalCaseMap response = api.getCasesFromId(user);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Updates a case
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateCaseTest() throws ApiException {
        CriminalCase theCase = null;
        Boolean response = api.updateCase(theCase);

        // TODO: test validations
    }
    
}
