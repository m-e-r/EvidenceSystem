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
import io.swagger.client.api.LoginApi;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.CriminalCaseMap;
import io.swagger.client.model.Evidence;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class ServerConnect implements IServerConnect{
    private ApiClient ac;
    private CriminalCaseApi cca;
    private EvidenceApi ea;
    private LoginApi la;
    private LawEnForcerApi lea;
    
    public ServerConnect() {
        this.ac = new ApiClient();
        this.ac.setBasePath("http://localhost:8080/kasper1/EvidenceManagerAPI/1");
        //this.ac.setBasePath("http://10.126.93.21:8080/kasper1/EvidenceManagerAPI/1");
        this.cca = new CriminalCaseApi(this.ac);
        this.ea = new EvidenceApi(this.ac);
        this.la = new LoginApi(this.ac);
        this.lea = new LawEnForcerApi(this.ac);
    }
    
    
    @Override
    public int doSomeLogin(String userName, String password) throws ApiException {
        int ans = this.la.doLogin(userName, password);
        return ans;
    }

    @Override
    public boolean addCase(CriminalCase theCase) throws ApiException {
        return this.cca.addCase(theCase);
    }

    @Override
    public boolean updateCase(CriminalCase theCase) throws ApiException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CriminalCase getCase(Integer caseId) throws ApiException {
        return cca.getCase(caseId);
    }

    @Override
    public CriminalCaseMap getCases(Integer employeeId) throws ApiException {
        return this.lea.lawEnforcerEmployeeIdGet(employeeId);
    }

    @Override
    public List<Evidence> findEvidence(String keyword) throws ApiException {
        return this.ea.getEvidenceList(keyword);
    }
}
