package dbConnection;

import io.swagger.api.impl.IsqlStatement;
import dbConnection.dbConnection;
import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;
import io.swagger.model.Evidence;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.NotImplementedException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruger
 */
public class sqlStatement implements IsqlStatement {

    private List<Evidence> tempEvidenceList;

    private dbConnection db;

    public sqlStatement() {

        db = new dbConnection();
    }
    
    /**
     * Method for adding a case in database.
     * @param c
     * @return 1
     */
    public boolean addCase(CriminalCase c) {
        System.err.println("Fra addCase i sqlStatement");

        String query = "INSERT INTO criminalcase (title, description, status) VALUES "
                + "('" + c.getCaseName() + "','" + c.getCaseDescription() + "','" + c.getStatus().toString() + "');";

        this.tempEvidenceList = c.getCaseEvidence();

        this.handleEvidence(tempEvidenceList, c.getId());

        return db.updateQuery(query) == 1;
    }
    
    /**
     * Method for updating Evidence in database from a list.
     * @param evidence
     * @param caseRef 
     */
    private void handleEvidence(List<Evidence> evidence, int caseRef) {
        if (!evidence.isEmpty()) {
            for (Evidence e : evidence) {
                if (e.getEvidenceNumber() == 0) {
                    this.addNewEvidence(e, caseRef);
                } else {
                    this.updateEvidence(e);
                }
            }
        }
    }
    
    /**
     * Method with SQL for adding new Evidence to Database. 
     * @param e
     * @param caseRef 
     */
    private void addNewEvidence(Evidence e, int caseRef) {
        //IMPORTANT! REPLACE e.getLocation() with title when available!!!!!!
        int evidenceId;
        try {
            String query = "INSERT INTO evidence (title, description)\n"
                    + "VALUES ('" + e.getLocation() + "', '" + e.getEvidenceDescription() + ") RETURNING _ref;";

            ResultSet select = db.executeQuery(query);
            while (select.next()) {
                evidenceId = select.getInt("_ref");
                String refQuery = String.format("INSERT INTO caseevidenceref (caseref, evidenceref) "
                        + "VALUES (%d, %d);", caseRef, evidenceId);
                db.executeQuery(refQuery);
            }

            //String query = "INSERT INTO ";
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    /**
     * Method for updating Evidence in database.
     * @param e 
     */
    private void updateEvidence(Evidence e) {
        //IMPORTANT! REPLACE e.getLocation() with title when available!!!!!!
        String query = String.format("UPDATE evidence SET title = '%s', description = '%s' WHERE _ref = %d;",
                e.getLocation(), e.getEvidenceDescription(), e.getEvidenceNumber());
        db.updateQuery(query);
    }
    
    /**
     * Method for updating case in database.
     * @param c
     * @return 
     */
    public boolean updateCase(CriminalCase c) {
        System.err.println(c.getCaseDescription() + c.getCaseName() + c.getId()+ "<------LOOOOOOOOOK HERE");
        String query = "UPDATE criminalcase SET title = '" + c.getCaseName()
                + "', description = '" + c.getCaseDescription() + "' WHERE _ref =" + c.getId() + ";";

        db.updateQuery(query);

        return db.updateQuery(query) == 1;
    }
    
    /**
     * Mehtod for getting a case from database.
     * @param Id
     * @return CriminalCase
     */
    public CriminalCase getCase(int Id) {

        CriminalCase ccase = new CriminalCase();

        try {
            String query = "SELECT _ref, title, description FROM criminalcase WHERE _ref =" + Id + ";";

            ResultSet set = db.executeQuery(query);

            while (set.next()) {

                ccase.setId(set.getInt("_ref"));
                ccase.setCaseName(set.getString("title"));
                ccase.setCaseDescription(set.getString("description"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(sqlStatement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ccase;
    }
    
    /**
     * Method for getting map with cases from database.
     * @param employeeId
     * @return CriminalCaseMap
     */
    @Override
    public CriminalCaseMap getCases(int employeeId) {
        CriminalCaseMap caseMap = new CriminalCaseMap();

        String query = String.format("SELECT criminalcase._ref, criminalcase.title FROM criminalcase\n"
                + "JOIN lawenforcercaseref ON (criminalcase._ref = lawenforcercaseref.caseref) \n"
                + "WHERE lawenforcercaseref.lawenforcerref = %d", employeeId);

        ResultSet select = db.executeQuery(query);
        try {
            while (select.next()) {
                caseMap.put(select.getString("_ref"), select.getString("title"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlStatement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return caseMap;

    }

}
