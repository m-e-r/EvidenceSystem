/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

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
    public String getPrevUserId(String valueFromEnum);

}
