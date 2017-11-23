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
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface to be used by the FXMLDocument controllers for calling methods
 * to the server.
 * @author Kasper
 */
public interface IServerConnect {
    //For Login
    public Token doSomeLogin(String userName, String password) throws ApiException;
    
    
    //For Case
    public boolean addCase(CriminalCase theCase) throws ApiException;
    public boolean updateCase(CriminalCase theCase) throws ApiException;
    public CriminalCase getCase(String caseId) throws ApiException;
    public CriminalCaseMap getCases(String employeeId) throws ApiException;
    public String generateCaseId() throws ApiException;
    
    
    //For Evidence
    public List<Evidence> findEvidence(String keyword) throws ApiException;
    public String generateEvidenceId() throws ApiException;
    
    
    //For User
    public boolean createNewUser(User user) throws ApiException;
    public List<User> getListOfUsers(String location) throws ApiException;
}
