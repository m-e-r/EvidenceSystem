/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLImplementation;

import dbConnection.DBConnection;
import io.swagger.model.Token;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.ILoginSQL;
import security.Passwords;

/**
 *
 * @author jacob
 */
public class LoginSQL implements ILoginSQL {
    
    private DBConnection db;
    
    public LoginSQL(){
        this.db = new DBConnection();
    }
    
    
    /**
     * Method to get the rank of a user from the database. Select the rank from
     * database corrosponding to an id
     *
     * @param id The id of the user from who we want to get the rank
     * @return The rank of the found user as a String
     */
    @Override
    public String getRank(String id) {
        System.out.println(id);

        String query = String.format("select title from lawenforcerposition where _ref = (SELECT positionref from lawenforcer where id = '%s')", id);

        ResultSet select = db.executeQuery(query);

        String position = null;
        int i = 1;
        try {
            while (select.next() | i == 1) {
                position = select.getString("title");
                System.out.println(position);
                i++;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return position;

    }
    
    /**
     * Method to check wether a user exists in the database using a username and
     * a password
     *
     * @param username The username of a user as a string
     * @param password The password of a user as a string
     * @return returns true if the user exists in the database, false if not.
     */
    @Override
    public boolean userExists(String username, String password) {
         String hashPassword = "";
        try {
            hashPassword = Passwords.passwordHashGenerator(password, true);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\n" + hashPassword);
        String query = "select username, passw from lawenforcer where username = '"
                + username + "' and passw = '" + hashPassword + "'";

        ResultSet select = db.executeQuery(query);

        try {
            return select.next();
        } catch (SQLException ex) {
            Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Method to get the id of a lawenforcer from the database
     *
     * @param username The username of the lawenforcer whoese id should be found
     * @param password The password of the lawenforcer whoese id should be found
     * @return The lawenforcerid found, as a string.
     */
    @Override
    public String getUserId(String username, String password) {

        String id = null;

        String query = "Select id from lawenforcer where username = '" + username + "' and passw = '" + password + "'";

        ResultSet select = db.executeQuery(query);

        try {
            while (select.next()) {
                id = select.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    @Override
    public String getSalt(String username) {
        String query = "Select passw from lawenforcer where username = '" + username + "'";

        ResultSet select = db.executeQuery(query);
        String [] saltArray = new String [3];
        
        try {
            while (select.next()) {
                try {
                    saltArray = select.getString("passw").split(":");
                } catch (SQLException ex) {
                    Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String salt = saltArray[1];
        
        return salt;
    }
    
    
    
}
