/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import SQLImplementation.IdGeneratorSQL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.TIMEOUT;

/**
 * Class used to generate pseudorandom id's for evidence and cases.
 *
 * @author Kasper
 */
public class IdGenerator {
    
    private int a, x, m; //Integers used is the math used to generate ids
    private IIdGeneratorSQL sql; //SecureSql interfaces. Is implemented i the SQLstatement class

    /**
     * Class constructor. Instantiates SQLStatement (sql)
     */
    public IdGenerator() {
        this.sql = new IdGeneratorSQL();

    }

    
    /**
     * Method used to generate a new case id.
     *
     * @return Returns the new case id as a string
     */
    public synchronized String generateCaseId() {
        this.x = Integer.parseInt(this.sql.getPrevCaseId()); //sql call
        this.a = 3;
        this.m = 729511;
        String prefix, body, toCheckOn, checkDigit, fullId;
        
        prefix = this.generatePrefix("yyMM"); //with the date format
        body = this.generateBody(100000); //with the min length
        toCheckOn = prefix + body;
        checkDigit = this.generateCheckDigit(toCheckOn);

        fullId = prefix + "-" + body + "-" + checkDigit;
        this.sql.updateCaseId(this.x + ""); //sql call
        return fullId;
    }

    /**
     * Method used to generate a new evidence id.
     *
     * @return Returns the new evidence id as a string
     */
    public synchronized String generateEvidenceId() {
        
            this.x = Integer.parseInt(this.sql.getPrevEvidenceId());
            this.a = 3;
            this.m = 7810294;

            String prefix, body, toCheckOn, checkDigit, fullId;
            prefix = this.generatePrefix("yyMM");
            body = this.generateBody(1000000);
            toCheckOn = prefix + body;
            checkDigit = this.generateCheckDigit(toCheckOn);

            fullId = prefix + "-" + body + "-" + checkDigit;
            this.sql.updateEvidenceId(this.x + "");
       
        
        return fullId;
    }

    /**
     * Method used to generate a user id.
     *
     * @param enumValue string value from the user type enum class
     * @return Returns a string containing the generated userid
     */
    public synchronized String generateUserId(String enumValue) {
         
        this.x = this.sql.getPrevUserId(enumValue);
        this.a = 3;
        this.m = 570926;

        String prefix, body;
        prefix = this.generatePrefix("yy");
        body = this.generateBody(100000);

        String s = enumValue + "-" + prefix + "-" + body;
        this.sql.updateUserId(body, enumValue);
        return s;
    }
    /**
     * Generates an id for the temp user in the database.
     * @return String id
     */
    public synchronized String generateTempUserId() {
        this.x = Integer.parseInt(this.sql.getPrevTempUserId());
        this.a = 3;
        this.m = 7321;
        String prefix, date, body, fullId;
        prefix = "NOTValidated";
        date = this.generatePrefix("dd/MM");
        body = this.generateBody(1000);

        fullId = prefix + "-" + date + body;
        this.sql.updateTempUserId(body);
        return fullId;
    }

    private String generatePrefix(String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date date = new Date();
        return df.format(date);
    }

    private String generateBody(int size) {
        while (Math.abs((a * x) % m) < size) {
            x = Math.abs((a * x) % m);
        }
        x = Math.abs((a * x) % m);
        return String.valueOf(x);
    }

    private String generateCheckDigit(String toCheckOn) {
        char[] getChecked = toCheckOn.toCharArray();
        int adder = 0;

        for (int i = 0; i < getChecked.length; i++) {
            adder += (i + 1) * Integer.parseInt(String.valueOf(getChecked[i]));
        }
        String checkDigit = String.valueOf(adder % 10);

        return checkDigit;
    }
}
