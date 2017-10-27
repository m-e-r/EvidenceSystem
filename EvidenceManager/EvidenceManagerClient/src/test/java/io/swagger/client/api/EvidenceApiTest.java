package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Evidence;
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
     * 
     *
     * Find evidence based on text
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findEvidenceTest() throws ApiException {
        String keyWord = null;
        // Evidence response = api.findEvidence(keyWord);

        // TODO: test validations
    }
    
    /**
     * Gets a list of evidence
     *
     * Returns a list of evidence
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEvidenceListTest() throws ApiException {
        // List<Evidence> response = api.getEvidenceList();

        // TODO: test validations
    }
    
}
