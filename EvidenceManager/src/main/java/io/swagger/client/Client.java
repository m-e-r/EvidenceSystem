/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.client;

import io.swagger.client.api.DefaultApi;

/**
 *
 * @author Kasper
 */
public class Client {

    private ApiClient client;
    private DefaultApi da;
    
    public Client() {
        this.client = new ApiClient();    
        client.setBasePath("http://localhost:8080/kasper1/LoginTester/1");
        this.da = new DefaultApi(client);
    }
    
    public boolean doSomeLogin(String userName, String password) throws ApiException {
        return this.da.findTheObject(userName, password);
    }

    
}
