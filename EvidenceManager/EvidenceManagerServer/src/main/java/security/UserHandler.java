/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.SQLStatement;
import io.swagger.api.impl.IsqlStatement;
import io.swagger.model.User;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class UserHandler {
    private IUserSql sql;
    private IsqlStatement sql2; //Noget rod. Få det ændret når vi merger!!
    private User user;
    private Generator gen;
    
    public UserHandler() {
        this.sql = new SQLStatement();
        this.sql2 = new SQLStatement();
        this.gen = new Generator();
    }
    
    public boolean addUser(User user) {
        this.user = user;
        this.user.setEmployeeId(this.gen.generateTempUserId());
        return this.sql.addUser(this.user);
    }
    
    public List<User> getListOfUsers(String location) {
        List<User> temp =this.sql2.getListOfUsers(location);
        for (User u : temp) {
            System.out.println(u.getName());
        }
        return temp;
    }
    
    public boolean validateUser(String userName) {
        return this.sql2.validateUser(userName) == this.sql2.setNewUserId(userName, this.gen.generateUserId("PO")); //Replace 'PO' when you get
                                                                                                    //User object as param
    }
}
