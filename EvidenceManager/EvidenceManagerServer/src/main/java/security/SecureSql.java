/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import io.swagger.model.UserType;

/**
 *
 * @author Kasper
 */
public interface SecureSql {
    public String getPrevCaseId();
    public String getPrevEvidenceId();
    
    public void updateCaseId(String id);
    public void updateEvidenceId(String id);
    
    public void updateUserId(String id, String role);
    public int getPrevUserId(String valueFromEnum);
    
    public boolean getPassAndName(String username, String password);
    
    public String getLawEnforcerId(String username, String password);
    
    public String getRank(String id);
    
    public void updateTempUserId(String id);
    public String getPrevTempUserId();
}
