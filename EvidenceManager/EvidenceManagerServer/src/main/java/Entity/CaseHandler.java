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
    
    /**
     * Returns the method of CaseHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    public boolean addCase(CriminalCase c){
        return this.handler.addCase(c);
    }
    
    /**
     * Returns the method of CaseHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    
    public boolean updateCase(CriminalCase c){
        return this.handler.updateCase(c);
    }
    
    /**
     * Returns the method of CaseHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    
    public CriminalCase getCase(String Id){
        return this.handler.getCase(Id);
    }
    
    /**
     * Returns the method of CaseHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    
    public CriminalCaseMap getCases(String employeeId){
        return this.handler.getCases(employeeId);
    }
    
    /**
     * Returns the method of CaseHandlerSQL class of the same name.
     * @param c
     * @return 
     */
    
    
    public boolean isBeingEdited(String id){
        return this.handler.isCaseBeingEdited(id);
    }
}
