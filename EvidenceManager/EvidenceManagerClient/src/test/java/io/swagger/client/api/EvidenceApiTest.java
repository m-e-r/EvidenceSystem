package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Evidence;
import io.swagger.client.model.Token;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EvidenceApi
 */
public class EvidenceApiTest {

    private final EvidenceApi api = new EvidenceApi();

    
    /**
     * Gets a list of Evidence
     *
     * Returns a list of Evidence
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEvidenceListTest() throws ApiException {
        Token token = null;
        // List<Evidence> response = api.getEvidenceList(token);

        // TODO: test validations
    }
    
    /**
     * pick up evidence
     *
     * pick up evidence
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pickUpEvidenceTest() throws ApiException {
        Evidence user = null;
        // Boolean response = api.pickUpEvidence(user);

        // TODO: test validations
    }
    
}
