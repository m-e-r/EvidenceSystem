/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.SQLStatement;
import io.swagger.api.impl.ILogin;
import io.swagger.model.Token;
import io.swagger.model.UserType;

/**
 * Class used to handle the login at server level. Class generates a token and communicates with the database
 * @author Bruger
 */
public class Login implements ILogin {

    SecureSql sql;

    /**
     * Class constructor. Instantiates a sqlStatement object.
     */
    public Login() {
        sql = new SQLStatement();
    }

    
    /**
     * Method to generate a token when user tries to login. Takes the username and password
     * as a string split by ";" and creates a Token if they exist in the database.
     * @param message A string containing the username and password split by a ";", ex: "username;password"
     * @return Return a Token object
     */
    @Override
    public Token doLogin(String message) {

        String[] s = new String[2];

        Token t = new Token();

        String text = this.decrypt(message);

        s = text.split(";");

        if (sql.getPassAndName(s[0], s[1])) {
            String id = this.sql.getLawEnforcerId(s[0], s[1]);
            t.setId(id);
            t.setUsertype(this.sql.getRank(id));
        }
        System.out.println(UserType.valueOf(t.getUsertype()) + " -- " + UserType.valueOf(t.getUsertype()).equals(UserType.COMISSIONER));
        return t;
    }

    public String hash(String text) {
        return text;
    }

    public String decrypt(String message) {
        return message;
    }

}
