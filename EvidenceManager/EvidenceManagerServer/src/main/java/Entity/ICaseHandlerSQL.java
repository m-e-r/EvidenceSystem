/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;

/**
 *
 * @author jacob
 */
public interface ICaseHandlerSQL {
    public boolean addCase(CriminalCase c);
    
    public boolean updateCase(CriminalCase c);
    
    public CriminalCase getCase(String Id);
    
    //public boolean addEvidence(Evidence e);
    
    public CriminalCaseMap getCases(String employeeId);
}
