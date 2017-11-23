/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.api.impl;

import io.swagger.model.CriminalCase;
import io.swagger.model.Evidence;
import java.util.List;
import io.swagger.model.CriminalCaseMap;
import io.swagger.model.LawEnforcer;
import io.swagger.model.User;
import io.swagger.model.UserType;

/**
 * Interface used for all the SQL statement methods. All functions that need to
 * call the database, should be present here.
 * @author MER
 */
public interface IsqlStatement {
    
    public boolean addCase(CriminalCase c);
    
    public boolean updateCase(CriminalCase c);
    
    public CriminalCase getCase(int Id);
    
    //public boolean addEvidence(Evidence e);
    
    public CriminalCaseMap getCases(String employeeId);

    public List<Evidence> getEvidenceList(String keyword);
    
    public Evidence pickupEvidence(Evidence evidence, LawEnforcer lawEnforcer);
    
    public void setUserPassword(LawEnforcer lawEnforcer, String newPassword);
    
    public Evidence getEvidence(int id);
    
    public void editEvidence(Evidence evidence);
    
    public List<Evidence> getAllEvidence(LawEnforcer forensic);
    
    public List<User> getListOfUsers(String location);
    
            
    
    
}
