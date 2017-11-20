/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.SQLStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MER
 */
public class UserIdGenerator {
        
    private static final int A = 3, M = 570926;
    private int x;
    private SecureSql sql;
        
    public UserIdGenerator() {
        this.sql = new SQLStatement();
    }

    public String generateUserId(String enumValue) {
        this.x = this.sql.getPrevUserId(enumValue);
        String s = enumValue + "-" + this.generatePrefix() + "-"  + this.generateBody(x);
        return s;
    }

    public String generatePrefix() {
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yy");
        return df.format(d);
    }

    public int generateBody(int x) {
        x = Math.abs((A * x) % M);
        while (x < 100000) {
            x = Math.abs((A * x) % M);
        }
        System.out.println(x);
        return x;
    }
        
}
