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
public interface ILoginSQL {
    
    public boolean getPassAndName(String username, String password);
    
    public String getLawEnforcerId(String username, String password);
    
    public String getRank(String id);
    
}
