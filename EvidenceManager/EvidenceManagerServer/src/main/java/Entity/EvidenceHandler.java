/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import SQLImplementation.EvidenceHandlerSQL;
import io.swagger.model.Evidence;
import io.swagger.model.User;
import java.util.List;

/**
 *
 * @author jacob
 */
public class EvidenceHandler {
    private IEvidenceHandlerSQL handler;
    
    public EvidenceHandler(){
        this.handler = new EvidenceHandlerSQL();
    }
    
    /**
     * Returns the method of EvidenceHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    
    public List<Evidence> getEvidenceList(String keyword){
        return this.handler.getEvidenceList(keyword);
    }
    
    
    /**
     * Returns the method of EvidenceHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    public Evidence pickupEvidence(Evidence evidence, String userId){
        return this.handler.pickupEvidence(evidence, userId);
    }
    
    
    /**
     * Returns the method of EvidenceHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    public Evidence getEvidence(int id){
        return this.handler.getEvidence(id);
    }
    
    
    /**
     * Returns the method of EvidenceHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    public void editEvidence(Evidence evidence){
        //TODO
    }
    
    
    /**
     * Returns the method of EvidenceHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    public List<Evidence> getAllEvidence(User forensic) {
        return this.handler.getAllEvidence(forensic);
    }
}
