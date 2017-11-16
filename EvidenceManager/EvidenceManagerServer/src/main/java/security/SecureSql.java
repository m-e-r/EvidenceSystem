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
    
    public void updateCaseId(int id);
    public void updateEvidenceId(int id);
    
    public void updateUserId(int id);
    public int getPrevUserId(String valueFromEnum);
    
    public boolean getPassAndName(String username, String password);
    
    public String getLawEnforcerId(String username, String password);
    
    public UserType getRank(String id);
}
