/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.api.impl;

import io.swagger.model.Token;

/**
 *
 * @author Kasper
 */
public interface Validator {
    public boolean callValidated(Token token);
}
