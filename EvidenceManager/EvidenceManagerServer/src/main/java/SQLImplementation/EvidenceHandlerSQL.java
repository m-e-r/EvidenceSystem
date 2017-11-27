/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLImplementation;

import dbConnection.DBConnection;
import io.swagger.model.Evidence;
import io.swagger.model.LawEnforcer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entity.IEvidenceHandlerSQL;

/**
 *
 * @author jacob
 */
public class EvidenceHandlerSQL implements IEvidenceHandlerSQL {

    private DBConnection db;
    
    public EvidenceHandlerSQL(){
        this.db = new DBConnection();
    }
    
  /**
     * Method to edit a piece of evidence. Updates a piece of evidence using an
     * evidence object.
     *
     * @param e The evidence with updated variables.
     */
    @Override
    public void editEvidence(Evidence e) {
        String query = String.format("UPDATE evidence SET title = '%s', description = '%s' WHERE id = '%s';",
                e.getTitle(), e.getDescription(), e.getId());
        db.updateQuery(query);
    }
    
     /**
     * Method to get a single evidence using evidence id
     *
     * @param id id of the wanted evidence as an int
     * @return Return the found evidence as an evidence object.
     */
    @Override
    public Evidence getEvidence(int id) {
        Evidence evidence = new Evidence();
        String query = String.format("SELECT * FROM evidence WHERE id = %s", id);
        ResultSet select = db.executeQuery(query);
        try {
            evidence.setId(select.getString("id"));
            evidence.setDescription(select.getString("description"));
            evidence.setTitle(select.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(EvidenceHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return evidence;
    }

    @Override
    public Evidence pickupEvidence(Evidence evidence, LawEnforcer lawEnforcer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   

     /**
     * Method to find all evidence connected to a forensic. This method doesn't
     * use a criminalcase to find evidence, but find them directly, using the
     * lawenforcer evidence reference.
     *
     * @param forensic The Lawenforcer object that should be connected to all
     * the evidence searched for
     * @return Returns a list of the found pieces of evidence.
     */
    @Override
    public List<Evidence> getAllEvidence(LawEnforcer forensic) {
        List<Evidence> evidenceList = new ArrayList<>();

        String query = String.format("SELECT evidence.id, evidence.title FROM evidence\n"
                + "JOIN lawenforcerevidenceref ON (evidence.id = lawenforcerevidenceref.evidenceId) \n"
                + "WHERE lawenforcerevidenceref.lawenforcerref = %d", forensic.getEmployeeId());

        ResultSet select = db.executeQuery(query);

        try {
            while (select.next()) {
                Evidence nextEvidence = new Evidence();
                nextEvidence.setId(select.getString("id"));
                nextEvidence.setDescription(select.getString("description"));
                nextEvidence.setTitle(select.getString("title"));
                evidenceList.add(nextEvidence);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return evidenceList;
    }

     @Override
    public List<Evidence> getEvidenceList(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
