/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.client;

import com.mycompany.evidencemanager.IServerConnect;
import io.swagger.client.api.CriminalCaseApi;
import io.swagger.client.api.EvidenceApi;
import io.swagger.client.api.LawEnForcerApi;
import io.swagger.client.api.SecurityApi;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.CriminalCaseMap;
import io.swagger.client.model.Evidence;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import java.util.List;

/**
 * This class makes the connection to the server possible for the client
 * @author Kasper
 */
public class ServerConnect implements IServerConnect{
    private ApiClient ac;
    private CriminalCaseApi cca;
    private EvidenceApi ea;
    private SecurityApi sa;
    private LawEnForcerApi lea;
    
    /**
     * The class' constructor. 
     * Initialize the apiClient and sets a path for the server.
     * Creates new apis for every class generated by swagger. 
     */
    public ServerConnect() {
        this.ac = new ApiClient();
        //this.ac.setBasePath("http://localhost:8080/m-e-r/Evidence/5");
        this.ac.setBasePath("http://10.126.118.185:8080/m-e-r/Evidence/5");
        this.cca = new CriminalCaseApi(this.ac);
        this.ea = new EvidenceApi(this.ac);
        this.sa = new SecurityApi(this.ac);
        this.lea = new LawEnForcerApi(this.ac);
    }
    
    /**
     * The user can login by the parameters and the login return value decides 
     * their access to the system.
     * @param userName the user name for the login
     * @param password password for the login
     * @return an integer.
     * @throws ApiException 
     */
    @Override
    public Token doSomeLogin(String userName, String password) throws ApiException {
        Token ans = this.sa.doLogin(userName, password);
        return ans; //Change this to token stuff
    }

    /**
     * The user can add a case to the database by sending a case object.
     * @param theCase is a case object 
     * @return 1 if the insert is succesfull and -1 if not. 
     * @throws ApiException 
     */
    @Override
    public boolean addCase(CriminalCase theCase) throws ApiException {
        return this.cca.addCase(theCase);
    }
    /**
     * Updates the case by sending a case object
     * @param theCase is a case object
     * @return 1 if the insert is succesfull and -1 if not. 
     * @throws ApiException 
     */
    @Override
    public boolean updateCase(CriminalCase theCase) throws ApiException {
        return this.cca.updateCase(theCase);
    }

    /**
     * Get a case using a  case Id
     * @param caseId is the case Id
     * @return a case Id 
     * @throws ApiException 
     */
    @Override
    public CriminalCase getCase(String caseId) throws ApiException {
        return cca.getCase(caseId);
    }

    /**
     * Gets a every case connected to a user with the specific employee Id
     * @param employeeId
     * @return a map with the cases. Documentation for class: criminalcase
     * @throws ApiException 
     */
    @Override
    public CriminalCaseMap getCases(String employeeId) throws ApiException {
        return this.lea.getCasesFromId(employeeId);
    }

    /**
     * Gets a list of evidence by wrinting a keyword, seach for title and 
     * description
     * @param keyword is a search word
     * @return a list with the evidence which is connected to the keyword
     * @throws ApiException 
     */
    @Override
    public List<Evidence> findEvidence(String keyword) throws ApiException {
        return this.ea.getEvidenceList(keyword);
    }

    @Override
    public String generateEvidenceId() throws ApiException {
        return this.sa.genEvidenceId();
    }

    @Override
    public String generateCaseId() throws ApiException {
        return this.sa.genCaseId();
    }

    @Override
    public boolean createNewUser(User user) throws ApiException {
        return this.sa.addUser(user);
    }
}
