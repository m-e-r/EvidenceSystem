package dbConnection;

import io.swagger.api.impl.IsqlStatement;
import dbConnection.dbConnection;
import io.swagger.model.CriminalCase;
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

    public boolean addCase(CriminalCase c) {
        System.err.println("Fra addCase i sqlStatement");

        String query = "INSERT INTO criminalcase (title, description) VALUES ('" + c.getCaseName() + "','" + c.getCaseDescription() + "');";

        //this.tempEvidenceList = c.getEvidence();
        this.tempEvidenceList = new ArrayList(); //replace with line above when method is implemented
        Evidence ev = new Evidence();
        ev.setEvidenceDescription("Heyyo");
        ev.setEvidenceNumber(400);
        ev.setLocation("Here");
        this.tempEvidenceList.add(ev); //remove this as well..

        this.handleEvidence(tempEvidenceList);
        
        return db.updateQuery(query) == 1;
    }
    
    private void handleEvidence(List<Evidence> evidence){
        this.tempEvidenceList = evidence;
        if (!this.tempEvidenceList.isEmpty()) {
            for (Evidence e : this.tempEvidenceList) {
                if (e.getEvidenceNumber() == 0) {
                    this.addNewEvidence(e);
                } else {
                    this.updateEvidence(e);
                }
            }
        }
    }

    private void addNewEvidence(Evidence e) {
        //IMPORTANT! REPLACE e.getLocation() with title when available!!!!!!
        String query = "INSERT INTO evidence (title, description)\n"
                + "VALUES ('" + e.getLocation() + "', '" + e.getEvidenceDescription() + ");";
        db.updateQuery(query);
        
    }

    private void updateEvidence(Evidence e) {
        //IMPORTANT! REPLACE e.getLocation() with title when available!!!!!!
        String query = String.format("UPDATE evidence SET title = '%s', description = '%s' WHERE _ref = %d;",
                e.getLocation(), e.getEvidenceDescription(), e.getEvidenceNumber());
        db.updateQuery(query);
    }

    public boolean updateCase(CriminalCase c) {

        String query = "UPDATE criminalcase SET title = '" + c.getCaseName() 
                + "', description = '" + c.getCaseDescription() + "' WHERE _ref =" + c.getId() + ";";
        
        return db.updateQuery(query) == 1;
    }

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

    public Evidence findEvidence(String keyWord) {

        throw new NotImplementedException("noob");
    }

    public boolean addEvidence(Evidence e) {

        throw new NotImplementedException("noob");
    }

}
