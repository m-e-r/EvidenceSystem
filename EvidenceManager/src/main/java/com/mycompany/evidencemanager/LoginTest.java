/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

/**
 *
 * @author Kasper
 */
public class LoginTest {
    private String userName, password;
    
    public LoginTest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public String toString() {
        return this.userName + "\n" + this.password;
    }
}
