package io.swagger.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kasper
 */
public abstract class Tokenfy {
    private Token token;
    
    public Token getToken() {
        return this.token;
    }
    
    public void setToken(Token token) {
        this.token = token;
    }
}
