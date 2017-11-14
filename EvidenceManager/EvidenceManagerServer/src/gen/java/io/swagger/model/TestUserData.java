package io.swagger.model;

import static io.swagger.model.TestUserData.TestUserDataEnum.COMISSIONER;
import static io.swagger.model.TestUserData.TestUserDataEnum.FORENSIC_SCIENTIST;
import static io.swagger.model.TestUserData.TestUserDataEnum.POLICE_OFFICER;
import static io.swagger.model.TestUserData.TestUserDataEnum.SYSTEM_ADMIN;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guest Account
 */
public class TestUserData {

public enum TestUserDataEnum {
    FORENSIC_SCIENTIST ("Forensic Scientist"), COMISSIONER ("Comissioner"), POLICE_OFFICER ("Police officer"), SYSTEM_ADMIN ("System admin");

private final String text;

private TestUserDataEnum (final String text){
    this.text = text;
}

    @Override
    public String toString() {
        return this.text;
    }

}

    public TestUserDataEnum selectEnum (String enumTest){
        TestUserDataEnum tude = null;
        
        switch (enumTest) {
                case "Comissioner":
                    tude = COMISSIONER;
                    break;
                case "Forensic scientist":
                    tude = FORENSIC_SCIENTIST;
                    break;
                case "Police officer":
                    tude = POLICE_OFFICER;
                    break;
                case "System admin":
                    tude = SYSTEM_ADMIN;
                    break;
                default:
                    System.err.println("No user privileges were able to be recognized");
                    break;
            }
        return tude;
    }




}
