/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import io.swagger.model.Evidence;
import io.swagger.model.User;
import java.util.List;

/**
 *
 * @author jacob
 */
public interface IEvidenceHandlerSQL {
    public List<Evidence> getEvidenceList(String keyword);
    
    public Evidence pickupEvidence(Evidence evidence, String userId);
    
    public Evidence getEvidence(int id);
    
    public void editEvidence(Evidence evidence);
    
    public List<Evidence> getAllEvidence(User forensic);
}
