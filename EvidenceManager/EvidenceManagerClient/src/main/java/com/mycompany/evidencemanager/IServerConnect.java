/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.CriminalCaseMap;
import io.swagger.client.model.Evidence;
import java.util.List;

/**
 * Interface to be used by the FXMLDocument controllers for calling methods
 * to the server.
 * @author Kasper
 */
public interface IServerConnect {
    //For Login
    public int doSomeLogin(String userName, String password) throws ApiException;
    
    
    //For Case
    public boolean addCase(CriminalCase theCase) throws ApiException;
    public boolean updateCase(CriminalCase theCase) throws ApiException;
    public CriminalCase getCase(Integer caseId) throws ApiException;
    public CriminalCaseMap getCases(Integer employeeId) throws ApiException;
    
    
    //For Evidence
    public List<Evidence> findEvidence(String keyword) throws ApiException;
}
