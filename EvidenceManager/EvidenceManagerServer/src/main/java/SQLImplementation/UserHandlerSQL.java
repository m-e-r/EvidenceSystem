/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLImplementation;

import dbConnection.DBConnection;
import io.swagger.model.Token;
import io.swagger.model.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.IUserHandlerSQL;
import security.Passwords;
import security.ServerSecurity;

/**
 *
 * @author jacob
 */
public class UserHandlerSQL implements IUserHandlerSQL {

    private DBConnection db;

    public UserHandlerSQL() {
        this.db = new DBConnection();
    }
    
    /**
     * Updates the user in the database.
     * @param user
     * @return boolean 
     */

    
    @Override
    public boolean updateUser(User user) {
        String query = String.format("UPDATE lawenforcer\n"
                + "   SET name='%s', positionref= (SELECT _ref FROM lawenforcerposition WHERE title='%s'), username='%s',\n"
                + "       address='%s'\n"
                + "   WHERE id = '%s';", user.getName(), user.getRole(), user.getUsername(), user.getAddress(), user.getEmployeeId());

        return this.db.updateQuery(query) == 1;
    }
    
    /**
     * Adds a user to the 
     * @param user
     * @return 
     */

    
    @Override
    public boolean addUser(User user) {
         
        String query = String.format("INSERT INTO lawenforcer(name, id, positionref,\n"
                + "username, passw, validated, address, birthday, locationref)\n"
                + "VALUES ('%s', '%s', (SELECT _ref FROM lawenforcerposition WHERE title = '%s'),\n"
                + "'%s', '%s', %b, '%s', '%s', \n"
                + "(SELECT locationref FROM lawenforcer WHERE id = '%s'))",
                user.getName(), user.getEmployeeId(), user.getRole().toUpperCase(),
                user.getUsername(), user.getPassword(), false, user.getAddress(), user.getBirthday(), user.getToken().getId());
         
        return this.db.updateQuery(query) == 1;
    }

    /**
     * Method used to get all users at the same location as the admin user who
     * views all users
     *
     * @param admin The lawenforcer object representing the admin user
     * @return Returns a list of lawenforcers at same location as admin
     */
    @Override
    public List<User> getListOfValidateUser(Token token) {
        List<User> allUsers = new ArrayList<>();
        User nextUser;
        String query = String.format("SELECT * FROM lawenforcer WHERE locationref "
                + "= (SELECT locationref FROM lawenforcer WHERE id = '%s') AND validated=false;", token.getId());

        ResultSet select = db.executeQuery(query);

        try {
            while (select.next()) {
                String name = select.getString("name");
                int role = select.getInt("positionref");
                String id = select.getString("id");
                String username = select.getString("username");
                String address = select.getString("address");
                String birthday = select.getString("birthday");

                String queryPosition = String.format("SELECT title FROM lawenforcerposition WHERE _ref = %d;", role);
                ResultSet pos = db.executeQuery(queryPosition);
                pos.next();

                nextUser = new User();
                nextUser.setName(name);
                nextUser.setRole(pos.getString(1));
                nextUser.setEmployeeId(id);
                nextUser.setUsername(username);
                nextUser.setAddress(address);
                nextUser.setBirthday(birthday);

                allUsers.add(nextUser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allUsers;
    }
    
    /**
     * Returns a list of users based on their token. 
     * @param token
     * @return List<User>
    */
    
    @Override
    public List<User> getListOfUsers(Token token) {
        List<User> listOfUsers = new ArrayList<>();
        User nextUser;
        String query = String.format("SELECT * FROM lawenforcer WHERE locationref "
                + "= (SELECT locationref FROM lawenforcer WHERE id = '%s');", token.getId());

        ResultSet select = db.executeQuery(query);

        try {
            while (select.next()) {
                
                String name = select.getString("name");
                int role = select.getInt("positionref");
                String id = select.getString("id");
                String username = select.getString("username");
                String address = select.getString("address");
                String birthday = select.getString("birthday");

                String queryPosition = String.format("SELECT title FROM lawenforcerposition WHERE _ref = %d;", role);
                ResultSet pos = db.executeQuery(queryPosition);
                pos.next();

                nextUser = new User();
                nextUser.setName(name);
                nextUser.setRole(pos.getString(1));
                nextUser.setEmployeeId(id);
                nextUser.setUsername(username);
                nextUser.setAddress(address);
                nextUser.setBirthday(birthday);

                listOfUsers.add(nextUser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfUsers;
    }

    /**
     * Sets a user to be validated.
     *
     * @param username
     * @return
     */
    @Override
    public boolean validateUser(User user) {
         
         
        String query = String.format("UPDATE public.lawenforcer\n"
                + "	SET validated=true, id = '%s', positionref = (SELECT _ref FROM lawenforcerposition WHERE title = '%s')\n"
                + "	WHERE username = '%s';", user.getEmployeeId(), user.getRole().toUpperCase(), user.getUsername());

         
         
         

        return this.db.updateQuery(query) == 1;

    }
    
    /**
     * Returns a user based on his id.
     * @param id
     * @return User
     */
    
    
    @Override
    public User getUser(String id) {
        User user = null;
        String query = String.format("Select * from lawenforcer where id = '%s'", id);

        ResultSet select = db.executeQuery(query);

        try {
            while (select.next()) {
                String name = select.getString("name");
                int role = select.getInt("positionref");
                String username = select.getString("username");
                String password = select.getString("passw");
                String address = select.getString("address");
                String birthday = select.getString("birthday");

                String queryPosition = String.format("SELECT title FROM lawenforcerposition WHERE _ref = %d;", role);
                ResultSet pos = db.executeQuery(queryPosition);
                pos.next();

                user = new User();
                user.setName(name);
                user.setRole(pos.getString(1));
                user.setEmployeeId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setAddress(address);
                user.setBirthday(birthday);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return user;
    }

}
