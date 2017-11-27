/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

/**
 *
 * @author MER
 */
public interface IIdGeneratorSQL {
    public String getPrevCaseId();
    public String getPrevEvidenceId();
    
    public void updateCaseId(String id);
    public void updateEvidenceId(String id);
    
    public void updateUserId(String id, String role);
    public int getPrevUserId(String valueFromEnum);
    
    public void updateTempUserId(String id);
    public String getPrevTempUserId();
}
