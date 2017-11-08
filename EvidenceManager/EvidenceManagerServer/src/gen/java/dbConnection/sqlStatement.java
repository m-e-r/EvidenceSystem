package dbConnection;

import io.swagger.api.impl.IsqlStatement;
import dbConnection.dbConnection;
import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;
import io.swagger.model.Evidence;
import io.swagger.model.LawEnforcer;
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
    @Override
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
     * Method to edit a piece of evidence. Updates a piece of evidence using an evidence object.
     * @param e The evidence with updated variables.
     */
    @Override
    public void editEvidence(Evidence e){
        updateEvidence(e);
    }
    
    /**
     * Method for updating case in database.
     * @param c
     * @return 
     */
    @Override
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
    @Override
    public CriminalCase getCase(int id) {

        CriminalCase ccase = new CriminalCase();

        try {
            String query = "SELECT _ref, title, description FROM criminalcase WHERE _ref =" + id + ";";

            ResultSet set = db.executeQuery(query);

            while (set.next()) {

                ccase.setId(set.getInt("_ref"));
                ccase.setCaseName(set.getString("title"));
                ccase.setCaseDescription(set.getString("description"));
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(sqlStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        ccase.setCaseEvidence(this.getEvidenceList(id));
        return ccase;
    }
    
    /**
     * Method for getting a evidence list from database.
     * @param CriminalCase
     * @return Evidence
     */
    private List<Evidence> getEvidenceList(int caseId){
        
        List<Evidence> eviList = new ArrayList();
        Evidence evi;
        try {
            String query = "SELECT evidence.title, evidence.description FROM evidence "
                    + "JOIN caseevidenceref ON (evidence._ref = caseevidenceref.evidenceref) "
                    + "WHERE caseevidenceref.caseref = "+ caseId +";";
            
           ResultSet set = db.executeQuery(query);
           while (set.next()){      
               evi = new Evidence();
               evi.setLocation(set.getString("title"));
               evi.setEvidenceDescription(set.getString("description"));
               eviList.add(evi);
           }
        } catch (SQLException ex) {
            Logger.getLogger(sqlStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return eviList;
    }
    
    
    /**
     * Method to get a single evidence using evidence id
     * @param id id of the wanted evidence as an int
     * @return  Return the found evidence as an evidence object.
     */
    @Override
    public Evidence getEvidence(int id){
        Evidence evidence = new Evidence();
        String query = String.format("SELECT * FROM evidence WHERE _ref = %d", id);
        ResultSet select = db.executeQuery(query);
        try {
            evidence.setEvidenceNumber(select.getInt("_ref"));
            evidence.setEvidenceDescription(select.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(sqlStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return evidence;
        
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
    
    

    @Override
    public List<Evidence> getEvidenceList(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evidence pickupEvidence(Evidence evidence, LawEnforcer lawEnforcer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserPassword(LawEnforcer lawEnforcer, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method to find all evidence connected to a forensic. This method doesn't
     * use a criminalcase to find evidence, but find them directly, using the 
     * lawenforcer evidence reference. 
     * @param forensic The Lawenforcer object that should be connected to all 
     * the evidence searched for
     * @return Returns a list of the found pieces of evidence. 
     */
    @Override
    public List<Evidence> getAllEvidence(LawEnforcer forensic) {
        List<Evidence> evidenceList = new ArrayList<>();
        
        String query = String.format("SELECT evidence._ref, evidence.title FROM evidence\n"
                + "JOIN lawenforcerevidenceref ON (evidence._ref = lawenforcerevidenceref.evidenceref) \n"
                + "WHERE lawenforcerevidenceref.lawenforcerref = %d", forensic.getEmployeeId());
        
        ResultSet select = db.executeQuery(query);
        
        try {
            while (select.next()){
                Evidence nextEvidence = new Evidence();
                nextEvidence.setEvidenceNumber(select.getInt("_ref"));
                nextEvidence.setEvidenceDescription(select.getString("title"));
                evidenceList.add(nextEvidence);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return evidenceList;
    }


    
    
}
