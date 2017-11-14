/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.sqlStatement;
import java.util.ArrayList;

/**
 *
 * @author MER
 */
public class UserIdGenerator {
        
    private static int a, m;
    private int x, count;
    private SecureSql sql;
    
        public UserIdGenerator() {
            this.sql = new sqlStatement();
            this.a = 3;
            this. m = 570926;
            this.count = 0;
        }
        
        public String generateUserId(String enumValue) {
            this.x = this.sql.getPrevUserId(enumValue);
            
        }
        
        
        public int generateBody(int x) {
                x = Math.abs((a * x) % m);
                while (x < 100000) {
                    x = Math.abs((a * x) % m);
                }
                System.out.println(x);
                return x;
        }
        
}
