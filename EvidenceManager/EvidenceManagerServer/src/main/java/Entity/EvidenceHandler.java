/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import SQLImplementation.EvidenceHandlerSQL;
import io.swagger.model.Evidence;
import io.swagger.model.LawEnforcer;
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
    
    public List<Evidence> getEvidenceList(String keyword){
        return this.handler.getEvidenceList(keyword);
    }
    
    public Evidence pickupEvidence(Evidence evidence, LawEnforcer lawEnforcer){
        return this.handler.pickupEvidence(evidence, lawEnforcer);
    }
    
    public Evidence getEvidence(int id){
        return this.handler.getEvidence(id);
    }
    
    public void editEvidence(Evidence evidence){
        //TODO
    }
    
    public List<Evidence> getAllEvidence(LawEnforcer forensic) {
        return this.handler.getAllEvidence(forensic);
    }
}