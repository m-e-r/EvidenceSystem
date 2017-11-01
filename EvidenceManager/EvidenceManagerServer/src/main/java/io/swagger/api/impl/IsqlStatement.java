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

/**
 *
 * @author MER
 */
public interface IsqlStatement {
    
    public boolean addCase(CriminalCase c);
    
    public boolean updateCase(CriminalCase c);
    
    public CriminalCase getCase(int Id);
    
    //public boolean addEvidence(Evidence e);
    
    public CriminalCaseMap getCases(int employeeId);

    //public Evidence getEvidenceList(CriminalCase c);
    
}
