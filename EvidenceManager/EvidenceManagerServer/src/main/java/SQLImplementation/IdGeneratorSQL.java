/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLImplementation;

import dbConnection.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.IIdGeneratorSQL;

/**
 *
 * @author jacob
 */
public class IdGeneratorSQL implements  IIdGeneratorSQL{

    private DBConnection db;
    
    public IdGeneratorSQL(){
        this.db = new DBConnection();
    }
    
    /**
     * Method to get the case id of the latest inserted case in the database.
     * Should be used to ??
     *
     * @return The latest caseid as a String
     */
    @Override
    public String getPrevCaseId() {
        String query = "SELECT caseid FROM latestid;";

        ResultSet select = db.executeQuery(query);
        String prevCaseiD = null;

        try {
            while (select.next()) {
                prevCaseiD = select.getString("caseid");

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return prevCaseiD;
    }

    /**
     * Method to get the evidence id of the latest inserted evidence in the
     * database. Should be used to ??
     *
     * @return The latest evidenceid as a String
     */
    @Override
    public String getPrevEvidenceId() {
        String query = "SELECT evidenceid FROM latestid;";

        ResultSet select = db.executeQuery(query);
        String prevCaseiD = null;

        try {
            while (select.next()) {
                prevCaseiD = select.getString("evidenceid");

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return prevCaseiD;
    }

    /**
     * Method to update the latest case id in the database. Should be called
     * whenever a new case is added.
     *
     * @param id The newest id as a string.
     */
    @Override
    public void updateCaseId(String id) {
        String query = "UPDATE latestid\n SET caseid= " + "'" + id + "'";
        db.updateQuery(query);
    }

    /**
     * Method to update the latest evidence id in the database. Should be called
     * whenever a new evidence is added.
     *
     * @param id The newest id as a string.
     */
    @Override
    public void updateEvidenceId(String id) {
        String query = "UPDATE latestid\n"
                + "   SET evidenceid=" + "'" + id + "'";

        db.updateQuery(query);
    }

    /**
     * Method to update the latest user id in the database table latestid.
     *
     * @param id The newest user id
     */
    @Override
    public void updateUserId(String id, String role) {
        System.out.println(role);
        String query = String.format("UPDATE latestid set %s = '%s';", role, id);
        db.updateQuery(query);
    }

    /**
     * Method to get the latest added userid in the database.
     *
     * @param valueFromEnum A string representing the usertype enum value, from
     * the UserType enum from the client This should be one of the toStrings
     * from the userype enum.
     * @return Returns the latest id from the specified usertype in the database
     */
    @Override
    public int getPrevUserId(String valueFromEnum) {
        int latestId = 0;
        String query = String.format("SELECT %s FROM latestId", valueFromEnum.toLowerCase());
        ResultSet select = db.executeQuery(query);
        try {
            while (select.next()) {
                latestId = select.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IdGeneratorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return latestId;
    }

    @Override
    public void updateTempUserId(String id) {
        String query = "UPDATE latestid\n SET temp= " + "'" + id + "'";
        db.updateQuery(query);
    }

    @Override
    public String getPrevTempUserId() {
        String latestId = null;
        String query = ("SELECT temp FROM latestId");
        ResultSet select = db.executeQuery(query);
        try {
            while (select.next()) {
                latestId = select.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IdGeneratorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return latestId;
    }
    
}
