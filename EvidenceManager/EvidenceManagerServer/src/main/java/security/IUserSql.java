/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import io.swagger.model.User;

/**
 *
 * @author Kasper
 */
public interface IUserSql {
    public boolean addUser(User user);

}
