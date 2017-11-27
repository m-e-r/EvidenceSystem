/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

import io.swagger.client.ApiException;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.CriminalCaseMap;
import io.swagger.client.model.Evidence;
import java.util.List;

/**
 *
 * @author Kasper
 */
public interface IEntity {
    public boolean addCase(CriminalCase theCase) throws ApiException;
    public boolean updateCase(CriminalCase theCase) throws ApiException;
    public CriminalCase getCase(String caseId) throws ApiException;
    
    public String generateEvidenceId() throws ApiException;
    public String generateCaseId() throws ApiException;
    
    public CriminalCaseMap getCases(String employeeId) throws ApiException;
    
    public List<Evidence> findEvidence(String keyword) throws ApiException;
}
