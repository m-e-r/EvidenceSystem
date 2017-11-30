/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import io.swagger.model.Token;
import io.swagger.model.User;
import java.util.List;

/**
 *
 * @author Kasper
 */
public interface IUserHandlerSQL {
    
    public boolean updateUser(User user);
    public boolean addUser(User user);
    public List<User> getListOfUsers(Token token);
    public boolean validateUser(User user);
    public User getUser(String id);
    
    

}
