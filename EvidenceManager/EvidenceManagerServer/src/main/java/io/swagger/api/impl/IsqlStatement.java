/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.api.impl;

import io.swagger.model.CriminalCase;
import io.swagger.model.Evidence;

/**
 *
 * @author MER
 */
public interface IsqlStatement {
    
    public boolean addCase(CriminalCase c);
    
    public boolean updateCase(CriminalCase c);
    
    public CriminalCase getCase(int Id);
    
    public Evidence findEvidence(String keyWord);
    
    public boolean addEvidence(Evidence e);
    
}
