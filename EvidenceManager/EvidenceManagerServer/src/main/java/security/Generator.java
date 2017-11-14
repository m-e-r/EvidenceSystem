/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dbConnection.sqlStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kasper
 */
public class Generator {
    private int a, x, m;
    private SecureSql sec;
    
    public Generator() {
        this.sec = new sqlStatement();        
    }
    
    public String generateCaseId() {
        this.x = this.prevCaseId();
        this.a =3;
        this.m = 729511;
        
        String prefix, body, toCheckOn, checkDigit, fullId;
        
        prefix = this.generatePrefix();
        body = this.generateBody();
        toCheckOn = prefix + body;
        checkDigit = this.generateCheckDigit(toCheckOn);
        
        fullId = prefix + "-" + body + "-" + checkDigit;
        this.sec.updateCaseId(this.x);
        return fullId;
    }    
    private int prevCaseId() {
        String[] prevCase = this.sec.getPrevCaseId().split("-");
        int prevId = Integer.parseInt(prevCase[2]);
        return prevId;
    }
    
    
    public String generateEvidenceId() {
        this.x = this.prevEvidenceId();
        this.a =3;
        this.m = 7810294;
        
        
        String prefix, body, toCheckOn, checkDigit, fullId;
        
        prefix = this.generatePrefix();
        body = this.generateBody();
        toCheckOn = prefix + body;
        checkDigit = this.generateCheckDigit(toCheckOn);
        
        fullId = prefix + "-" + body + "-" + checkDigit;
        this.sec.updateEvidenceId(this.x);
        return fullId;
    } 
    private int prevEvidenceId() {
        String[] prevEvidence = this.sec.getPrevEvidenceId().split("-");
        int prevId = Integer.parseInt(prevEvidence[2]);
        return prevId;
    }
    
    
    private String generatePrefix() {
        DateFormat df = new SimpleDateFormat("yyMM");
        Date date = new Date();
        return df.format(date);
    }
     
  
    private String generateBody() {
        while (Math.abs((a * x) % m) < 1000000) {
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
