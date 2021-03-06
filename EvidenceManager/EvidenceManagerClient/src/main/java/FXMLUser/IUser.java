/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLUser;

import io.swagger.client.ApiException;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import java.util.List;

/**
 *
 * @author Kasper
 */
public interface IUser {
    public boolean createNewUser(User user) throws ApiException;
    public List<User> getListOfUsers(Token token) throws ApiException;
   // public List<User> getUsersList(String location) throws ApiException;
    public boolean validateUser(User user) throws ApiException;
    
    public User getUser(String id, Token token) throws ApiException;
    
    public Token doSomeLogin(String userName, String password) throws ApiException;
    public boolean updateUser(User user) throws ApiException;
}
