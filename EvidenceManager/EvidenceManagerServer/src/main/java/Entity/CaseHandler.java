/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import SQLImplementation.CaseHandlerSQL;
import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;

/**
 *
 * @author jacob
 */
public class CaseHandler {
    public ICaseHandlerSQL handler;
    
    public CaseHandler(){
        this.handler = new CaseHandlerSQL();
    }
    
    public boolean addCase(CriminalCase c){
        return this.handler.addCase(c);
    }
    
    public boolean updateCase(CriminalCase c){
        return this.handler.updateCase(c);
    }
    
    public CriminalCase getCase(int Id){
        return this.handler.getCase(Id);
    }
    
    //public boolean addEvidence(Evidence e);
    
    public CriminalCaseMap getCases(String employeeId){
        return this.handler.getCases(employeeId);
    }
}
