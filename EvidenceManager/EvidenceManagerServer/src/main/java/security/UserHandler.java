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
    private IUserHandlerSQL sql;
    private IsqlStatement sql2; //Noget rod. Få det ændret når vi merger!!
    private User user;
    private IdGenerator gen;
    
    public UserHandler() {
        this.sql = new SQLStatement();
        this.sql2 = new SQLStatement();
        this.gen = new IdGenerator();
    }
    
    /**
     * Adds a new user to the database after assigning it a temporary id.
     * This user will need validation before having access to the system.
     * @param user the user to be added
     * @return true if the sql statement was successfull
     */
    public boolean addUser(User user) {
        this.user = user;
        this.user.setEmployeeId(this.gen.generateTempUserId());
        return this.sql.addUser(this.user);
    }
    
    /**
     * Returns a list of users who are associated with the given location in the 
     * database.
     * @param location
     * @return 
     */
    public List<User> getListOfUsers(String location) {
        return this.sql2.getListOfUsers(location);
    }
    
    /**
     * Validates a user in the database and assigsn it a new id.
     * @param userName
     * @return false if either sql statement fails.
     */
    public boolean validateUser(String userName) {
        String newId = this.gen.generateUserId("PO"); //Replace 'PO' when you get User object as param
        
        if (this.sql2.validateUser(userName))
            return this.sql2.setNewUserId(userName, newId);
        
        return false;
    }
}
