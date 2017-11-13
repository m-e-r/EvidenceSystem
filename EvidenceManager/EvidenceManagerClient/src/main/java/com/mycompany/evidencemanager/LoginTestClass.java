/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

import com.mycompany.evidencemanager.LoginTestClass.UserType;

/**
 *
 * @author Guest Account
 */
public class LoginTestClass {

    public enum UserType {
        COMISSIONER, FORENSIC_SCIENTIST, POLICE_OFFICER, SYSTEM_ADMIN
    }

    public UserType doLoginUserType(String username, String password) {
        UserType ut = null;
        System.err.println(password);
        System.err.println(username);
        if (password.equals("123")) {
            switch (username) {
                case "Comissioner":
                    ut = UserType.COMISSIONER;
                    break;
                case "Forensic scientist":
                    ut = UserType.FORENSIC_SCIENTIST;
                    break;
                case "Police officer":
                    ut = UserType.POLICE_OFFICER;
                    break;
                case "System admin":
                    ut = UserType.SYSTEM_ADMIN;
                    break;
                default:
                    System.err.println("No user privileges were able to be recognized");
                    break;
            }

        } else {

            System.err.println("Incorrect password");
        }
        System.out.println(ut);
        return ut;
    }

}
