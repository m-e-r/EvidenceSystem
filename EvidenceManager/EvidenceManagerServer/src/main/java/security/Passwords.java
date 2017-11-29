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
    
    private static ILoginSQL sql;
    private static final int KEY_LENGTH = 320;
    private static final int ITERATIONS = 1000;
    
    public Passwords() {
        this.sql = new LoginSQL();
    }

    public static byte[] getNextSalt() throws NoSuchAlgorithmException {
        byte[] salt = new byte[160];
        
        return salt;
    }

    public static String passwordHashGenerator(String password, boolean userExists) throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] charPassword = password.toCharArray();
        byte[] salt;
        
        if (!userExists) {
          salt = getNextSalt();
        } else {
          salt = hexStringToByteArray(sql.getSalt(password));
        }
        
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(charPassword, salt, ITERATIONS, KEY_LENGTH);
        SecretKey key = skf.generateSecret(spec);
        byte[] hash = key.getEncoded();

        return String.valueOf(ITERATIONS)+":"+toHex(salt)+":"+toHex(hash);
    }

    public static String toHex(byte[] array) {
        BigInteger big = new BigInteger(1, array);
        String hex = big.toString(16);
        
        int paddingLength = (array.length*2)-hex.length();
        
        if(paddingLength>0){
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
      
    }
    
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
}
    
   
}
