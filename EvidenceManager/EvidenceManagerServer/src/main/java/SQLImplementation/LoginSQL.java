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
        this.db.startConnection();
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

        String query = String.format("select title from lawenforcerposition where _ref = (SELECT positionref from lawenforcer where id = '%s')", id);

        ResultSet select = db.executeQuery(query);

        String position = null;
        int i = 1;
        try {
            while (select.next() | i == 1) {
                position = select.getString("title");
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
        String query = String.format("select username, passw from lawenforcer where username = '%s' and passw = '%s'", username, password);
        ResultSet select = db.executeQuery(query);
        String[] test = password.split(":");
        System.out.println(test[0].equals("1000"));
        System.out.println(test[1].equals("43e418504165b42067630af43ca485b983f490436ca235456846ce38c3c9cbdf792ee8614fc629e594d73f3288d43fa2da1eff5e2bcdf9631df6c87b4cca5ad3b408b3a17a6869b2d86da0a3b8a0f79d278629c60feef60a95d388f938cd8e496c6e4229a2a23ab5f63390434f5d98433f131d082d0ce9ccb669a3aa3312dab3e2a117a398c693a3ae7787f2dafb4efeddb2042a265f9c278d172a334132a021"));
        System.out.println(test[2].equals("b2a1ae045134e4240b875fed0c80738b9f244d00181fbe4340263269c1a8710c4029e07fe1827c3e"));
       
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
        String temp = "";
        
        
        try {
            while (select.next()) {
                    temp = select.getString("passw");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        saltArray = temp.split(":");
        String salt = saltArray[1];
        
        return salt;
    }
    
    
    
}
