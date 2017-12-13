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
    private IIdGeneratorSQL sec; //SecureSql interfaces. Is implemented i the SQLstatement class

    /**
     * Class constructor. Instantiates SQLStatement (sec)
     */
    public IdGenerator() {
        this.sec = new IdGeneratorSQL();

    }

    /**
     * Method used to generate a new case id.
     *
     * @return Returns the new case id as a string
     */
    public synchronized String generateCaseId() {
        this.x = Integer.parseInt(this.sec.getPrevCaseId());
        System.out.println("Latest id: " + this.x);
        this.a = 3;
        this.m = 729511;
        
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(IdGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        String prefix, body, toCheckOn, checkDigit, fullId;
        
        prefix = this.generatePrefix("yyMM");
        body = this.generateBody(10000);
        toCheckOn = prefix + body;
        checkDigit = this.generateCheckDigit(toCheckOn);

        fullId = prefix + "-" + body + "-" + checkDigit;
        System.out.println("New Id: " + fullId);
        this.sec.updateCaseId(this.x + "");
        return fullId;
    }

    /**
     * Method used to generate a new evidence id.
     *
     * @return Returns the new evidence id as a string
     */
    public synchronized String generateEvidenceId() {

            this.x = Integer.parseInt(this.sec.getPrevEvidenceId());
            this.a = 3;
            this.m = 7810294;

            String prefix, body, toCheckOn, checkDigit, fullId;
            prefix = this.generatePrefix("yyMM");
            body = this.generateBody(1000000);
            toCheckOn = prefix + body;
            checkDigit = this.generateCheckDigit(toCheckOn);

            fullId = prefix + "-" + body + "-" + checkDigit;
            this.sec.updateEvidenceId(this.x + "");
       
        
        return fullId;
    }

    /**
     * Method used to generate a user id.
     *
     * @param enumValue string value from the user type enum class
     * @return Returns a string containing the generated userid
     */
    public synchronized String generateUserId(String enumValue) {
         
        this.x = this.sec.getPrevUserId(enumValue);
        this.a = 3;
        this.m = 570926;

        String prefix, body;
        prefix = this.generatePrefix("yy");
        body = this.generateBody(100000);

        String s = enumValue + "-" + prefix + "-" + body;
        this.sec.updateUserId(body, enumValue);
        return s;
    }
    /**
     * Generates an id for the temp user in the database.
     * @return String id
     */
    public synchronized String generateTempUserId() {
        this.x = Integer.parseInt(this.sec.getPrevTempUserId());
        this.a = 3;
        this.m = 7321;
        String prefix, date, body, fullId;
        prefix = "NOTValidated";
        date = this.generatePrefix("dd/MM");
        body = this.generateBody(1000);

        fullId = prefix + "-" + date + body;
        this.sec.updateTempUserId(body);
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
