/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.sqlStatement;
import io.swagger.api.impl.ILogin;
import io.swagger.model.Token;
import io.swagger.model.UserType;

/**
 *
 * @author Bruger
 */
public class Login implements ILogin {

    SecureSql sql;

    public Login() {
        sql = new sqlStatement();
    }

    @Override
    public Token doLogin(String message) {

        String[] s = new String[2];

        Token t = new Token();

        String text = this.decrypt(message);

        s = text.split(";");

        if (sql.getPassAndName(s[0], s[1])) {

            t.setId(sql.getLawEnforcerId(s[0], s[1]));
            t.setUsertype(sql.getRank(s[0]));
        }

        return t;

    }

    public String hash(String text) {

        return text;
    }

    public String decrypt(String message) {

        return message;
    }

}
