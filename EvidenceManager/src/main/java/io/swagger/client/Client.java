/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.client;

import io.swagger.client.api.LoginApi;

/**
 *
 * @author Kasper
 */
public class Client {
    private ApiClient ac;
    LoginApi la;
    
    public Client() {
        this.ac = new ApiClient();
        this.ac.setBasePath("http://10.126.93.21:8080/kasper1/EvidenceManagerAPI/1");
        this.la = new LoginApi(ac);
    }
    
    
    public boolean doSomeLogin(String userName, String password) throws ApiException {
        
        boolean ans = this.la.doLogin(userName, password);
        System.out.println(ans);
        return ans;
    }
}
