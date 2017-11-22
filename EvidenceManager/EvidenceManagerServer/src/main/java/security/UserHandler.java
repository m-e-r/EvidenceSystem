/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.SQLStatement;
import io.swagger.model.User;

/**
 *
 * @author Kasper
 */
public class UserHandler {
    private IUserSql sql;
    private User user;
    private Generator gen;
    
    public UserHandler() {
        this.sql = new SQLStatement();
        this.gen = new Generator();
    }
    
    public boolean addUser(User user) {
        this.user = user;
        this.user.setEmployeeId(this.gen.generateTempUserId());
        return this.sql.addUser(this.user);
    }
}
