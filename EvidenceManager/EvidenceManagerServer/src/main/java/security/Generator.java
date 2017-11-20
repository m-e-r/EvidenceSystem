/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.SQLStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class used to generate pseudorandom id's for users, evidence and cases. 
 * @author Kasper
 */
public class Generator {
    private int a, x, m; //Integers used is the math used to generate ids
    private SecureSql sec; //SecureSql interfaces. Is implemented i the SQLstatement class
    
    /**
     * Class constructor. Instantiates SQLStatement (sec)
     */
    public Generator() {
        this.sec = new SQLStatement();        
    }
    
    /**
     * 
     * @return 
     */
    public String generateCaseId() {
        this.x = Integer.parseInt(this.sec.getPrevCaseId());
        System.out.println("x: " + this.x);
        this.a =3;
        this.m = 729511;
        
        String prefix, body, toCheckOn, checkDigit, fullId;
        
        prefix = this.generatePrefix();
        body = this.generateBody(10000);
        toCheckOn = prefix + body;
        checkDigit = this.generateCheckDigit(toCheckOn);
        
        fullId = prefix + "-" + body + "-" + checkDigit;
        System.out.println(fullId);
        this.sec.updateCaseId(this.x+"");
        return fullId;
    }    
    
    
    public String generateEvidenceId() {
        this.x = Integer.parseInt(this.sec.getPrevEvidenceId());
        this.a =3;
        this.m = 7810294;
        
        
        String prefix, body, toCheckOn, checkDigit, fullId;
        
        prefix = this.generatePrefix();
        body = this.generateBody(1000000);
        toCheckOn = prefix + body;
        checkDigit = this.generateCheckDigit(toCheckOn);
        
        fullId = prefix + "-" + body + "-" + checkDigit;
        this.sec.updateEvidenceId(this.x+"");
        return fullId;
    } 
    
    
    private String generatePrefix() {
        DateFormat df = new SimpleDateFormat("yyMM");
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
            adder += (i+1) * Integer.parseInt(String.valueOf(getChecked[i]));
        }
        String checkDigit = String.valueOf(adder % 10);
        
        return checkDigit;
    }
}
