/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import SQLImplementation.LoginSQL;
import io.swagger.api.impl.ILogin;
import io.swagger.model.Token;
import io.swagger.model.UserType;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Class used to handle the login at server level. Class generates a token and
 * communicates with the database
 *
 * @author Bruger
 */
public class Login implements ILogin {
    private static final int KEY_LENGTH = 160;
    ILoginSQL sql;
    private Passwords pass;

    /**
     * Class constructor. Instantiates a sqlStatement object.
     */
    public Login() {
        sql = new LoginSQL();
        this.pass = new Passwords();
    }

    /**
     * Method to generate a token when user tries to login. Takes the username
     * and password as a string split by ";" and creates a Token if they exist
     * in the database.
     *
     * @param message A string containing the username and password split by a
     * ";", ex: "username;password"
     * @return Return a Token object
     */
    @Override
    public Token doLogin(String message) {
        String[] sA = message.split(";");
        if (sA[0].trim().isEmpty() || sA[1].trim().isEmpty()) {
            return new Token();
        }
        ServerSecurity ss = new ServerSecurity();
        sA[0] = ss.decrypt(sA[0]);
        sA[1] = ss.decrypt(sA[1]);

        
        try {
            sA[1] = this.pass.passwordHashGenerator(sA[1], sA[0], this.sql.usernameExists(sA[0]));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        Token t = new Token();

        if (this.userExists(sA[0], sA[1])) {
            System.out.println("User exists så det her sker");
            Date d = new Date(); 
            String id = this.getUserId(sA[0], sA[1]);
            
            if (!this.isUserValidated(id) || !this.isUserSupportedType(id)){
                System.out.println("Ikke særlig godt validated");
                return t;
    }
            System.out.println(id);
            t.setId(id);
            t.setUsertype(this.getRank(id));
            t.setName(this.sql.getName(id));
            t.setTimeStamp(Long.toString(d.getTime()));
        }
        //System.out.println(UserType.valueOf(t.getUsertype()) + " -- " + UserType.valueOf(t.getUsertype()).equals(UserType.COMISSIONER));
        return t;
    }
    
    /**
     * Method that checks if the user is not validated using a userId
     * @param id The id of the user, that should be checked if is validated
     * @return Returns true if user is validated
     */
    private boolean isUserValidated(String id){
        return !id.contains("NOTValidated");
    }
    
    /**
     * Method that check if the id of a user, shows that the user is a supported usertype.
     * @param id User id of the user that should be checked
     * @return Returns true if the user is of a proper type.
     */
    private boolean isUserSupportedType(String id){
        String userType = id;
        return userType.contains("POLICE_OFFICER") || userType.contains("COMISSIONER") 
                || userType.contains("SYSTEM_ADMIN") || userType.contains("FORENSIC_SCIENTIST");
    }

    public boolean userExists(String username, String password) {
        return this.sql.userExists(username, password);
    }

    public String getUserId(String username, String password) {
        return this.sql.getUserId(username, password);
    }

    public String getRank(String id) {
        return this.sql.getRank(id);
    }

//    public static boolean validatePasswords(String originalPassword, String storedPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {
//        String[] parts = storedPassword.split(":");
//        int iterations = Integer.parseInt(parts[0]);
//        byte[] salt = fromHex(parts[1]);
//        byte[] hash = fromHex(parts[2]);
//        
//        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, KEY_LENGTH);
//        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//        byte[] testHash = skf.generateSecret(spec).getEncoded();
//        
//        int diff = hash.length^testHash.length;
//        
//         for(int i = 0; i < hash.length && i < testHash.length; i++)
//        {
//            diff |= hash[i] ^ testHash[i];
//        }
//        
//        return diff == 0;
//    }

    private static byte[] fromHex(String hex) {

        byte[] bytes = new byte[hex.length() / 2];
        for(int i =0; i<bytes.length; i++){
            bytes[i] = (byte) Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return bytes;
    }

}
