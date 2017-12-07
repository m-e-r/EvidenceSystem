/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import SQLImplementation.LoginSQL;
import SQLImplementation.UserHandlerSQL;
import io.swagger.model.Token;

import io.swagger.model.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class UserHandler {
    private IUserHandlerSQL handler;
    private ILoginSQL login; //Noget rod. Få det ændret når vi merger!!
    private User user;
    private IdGenerator gen;
    private Passwords pass;
    private ServerSecurity ss;
    
    public UserHandler() {
        this.handler = new UserHandlerSQL();
        this.login = new LoginSQL();
        this.gen = new IdGenerator();
        this.pass = new Passwords();
        this.ss = new ServerSecurity();
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
        String hashPassword = "";
        this.user = user;
        this.user.setEmployeeId(this.gen.generateTempUserId());
        
        
        
        String password = this.ss.decrypt(user.getPassword());
        String username = this.ss.decrypt(user.getUsername());
        
        
        
        
        try {
            hashPassword = this.pass.passwordHashGenerator(password, username, false);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        user.setUsername(username);
        user.setPassword(hashPassword);
        
        return this.handler.addUser(this.user);
    }
    
    /**
     * Returns a list of users who are associated with the given location in the 
     * database.
     * @param location
     * @return 
     */
    public List<User> getListOfUsers(Token token) {
        return this.handler.getListOfUsers(token);
    }
    
    public List<User> getListOfValidateUser(Token token) {
        return this.handler.getListOfValidateUser(token);
    }
    
    /**
     * Validates a user in the database and assigsn it a new id.
     * @param userName
     * @return false if either sql statement fails.
     */
    public boolean validateUser(User user) {
        String newId = this.gen.generateUserId(user.getRole().toUpperCase()); //Replace 'PO' when you get User object as param
        user.setEmployeeId(newId);
        return this.handler.validateUser(user);
   
    }
}
