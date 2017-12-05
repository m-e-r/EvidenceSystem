/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import SQLImplementation.LoginSQL;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Passwords {
    
    private ILoginSQL sql;
    private final int KEY_LENGTH = 320;
    private final int ITERATIONS = 1000;
    
    public Passwords() {
        this.sql = new LoginSQL();
    }

    public byte[] getNextSalt() throws NoSuchAlgorithmException {
        byte[] salt = new byte[160];
        SecureRandom.getInstanceStrong().nextBytes(salt);
        return salt;
    }

    public String passwordHashGenerator(String password, String username, boolean userExists) throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] charPassword = password.toCharArray();
        byte[] salt;
        
        if (!userExists) {
            System.out.println("Findes ikke");
          salt = this.getNextSalt();
        } else {
            System.out.println("Findes godt");
          salt = this.hexStringToByteArray(sql.getSalt(username));
        }
        
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(charPassword, salt, ITERATIONS, KEY_LENGTH);
        SecretKey key = skf.generateSecret(spec);
        byte[] hash = key.getEncoded();
        
        String s = String.valueOf(ITERATIONS)+":"+toHex(salt)+":"+toHex(hash);
        System.out.println("længde: " + s.split(":").length);
        return s;
    }

    public String toHex(byte[] array) {
        BigInteger big = new BigInteger(1, array);
        String hex = big.toString(16);
        
        int paddingLength = (array.length*2)-hex.length();
        
        if(paddingLength>0){
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
      
    }
    
    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
}
    
   
}
