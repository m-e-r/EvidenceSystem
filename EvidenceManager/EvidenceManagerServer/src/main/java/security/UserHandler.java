/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import SQLImplementation.LoginSQL;
import SQLImplementation.UserHandlerSQL;

import io.swagger.api.impl.IsqlStatement;
import io.swagger.model.User;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class UserHandler {
    private IUserHandlerSQL handler;
    private ILoginSQL login; //Noget rod. Få det ændret når vi merger!!
    private User user;
    private IdGenerator gen;
    
    public UserHandler() {
        this.handler = new UserHandlerSQL();
        this.login = new LoginSQL();
        this.gen = new IdGenerator();
    }
    
    public User getUser(String id){
        return this.handler.getUser(id);
    }
    
    public boolean updateUser(User user){
        return this.handler.updateUser(user);
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
        return this.handler.addUser(this.user);
    }
    
    /**
     * Returns a list of users who are associated with the given location in the 
     * database.
     * @param location
     * @return 
     */
    public List<User> getListOfUsers(String location) {
        return this.handler.getListOfUsers(location);
    }
    
    /**
     * Validates a user in the database and assigsn it a new id.
     * @param userName
     * @return false if either sql statement fails.
     */
    public boolean validateUser(String userName) {
        String newId = this.gen.generateUserId("PO"); //Replace 'PO' when you get User object as param
        
        return this.handler.validateUser(userName, newId);
   
    }
}
