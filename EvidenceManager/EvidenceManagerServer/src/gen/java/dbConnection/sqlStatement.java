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

    public boolean addCase(CriminalCase c) {
        System.err.println("Fra addCase i sqlStatement");

        String query = "INSERT INTO criminalcase (title, description, status) VALUES "
                + "('" + c.getCaseName() + "','" + c.getCaseDescription() + "','" + c.getStatus().toString() + "');";

        this.tempEvidenceList = c.getCaseEvidence();

        this.handleEvidence(tempEvidenceList, c.getId());

        return db.updateQuery(query) == 1;
    }

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

    private void updateEvidence(Evidence e) {
        //IMPORTANT! REPLACE e.getLocation() with title when available!!!!!!
        String query = String.format("UPDATE evidence SET title = '%s', description = '%s' WHERE _ref = %d;",
                e.getLocation(), e.getEvidenceDescription(), e.getEvidenceNumber());
        db.updateQuery(query);
    }

    public boolean updateCase(CriminalCase c) {

        String query = "UPDATE criminalcase SET title = '" + c.getCaseName()
                + "', description = '" + c.getCaseDescription() + "' WHERE _ref =" + c.getId() + ";";

        db.updateQuery(query);

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

    @Override
    public CriminalCaseMap getCases(int employeeId) {
        CriminalCaseMap caseMap = new CriminalCaseMap();
        
        String query = String.format("SELECT (_ref, title) FROM criminalcase\n"
                + "WHERE _ref = (SELECT _ref FROM lawenforcercaseref WHERE _ref = %d)", employeeId);
        
        ResultSet select = db.executeQuery(query);
        try {
            while (select.next()){
                caseMap.put(select.getString("_ref"), select.getString("title"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return caseMap;
        
    }

}
