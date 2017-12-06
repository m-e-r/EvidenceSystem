/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLImplementation;

import Entity.ICaseHandlerSQL;
import dbConnection.DBConnection;
import io.swagger.model.CaseStatus;
import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;
import io.swagger.model.Evidence;
import io.swagger.model.Suspect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacob
 */
public class CaseHandlerSQL implements ICaseHandlerSQL {

    private List<Evidence> tempEvidenceList;
    private DBConnection db;

    public CaseHandlerSQL() {
        this.db = new DBConnection();
    }

    /**
     * Method for getting map with cases from database.
     *
     * @param employeeId
     * @return CriminalCaseMap
     */
    @Override
    public CriminalCaseMap getCases(String employeeId) {
        CriminalCaseMap caseMap = new CriminalCaseMap();

        String query = String.format("SELECT id, title FROM criminalcase where responsible = '%s'", employeeId);

        ResultSet select = db.executeQuery(query);
        try {
            while (select.next()) {
                caseMap.put(select.getString("id"), select.getString("title"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return caseMap;

    }

    /**
     * Mehtod for getting a case from database.
     *
     * @param Id
     * @return CriminalCase
     */
    @Override
    public CriminalCase getCase(String id) {

        CriminalCase ccase = new CriminalCase();

        try {
            String query = String.format("SELECT criminalcase.title, criminalcase.description, criminalcase.status, criminalcase.id, criminalcase.isbeingedited, lawenforcer.name FROM criminalcase\n"
                    + "JOIN lawenforcer ON (lawenforcer.id = criminalcase.responsible) WHERE criminalcase.id = '%s'", id);

            ResultSet select = db.executeQuery(query);

            while (select.next()) {

                
                String title = select.getString("title");
                String description = select.getString("description");
                String status = select.getObject("status").toString();
                boolean isBeingEdited = select.getBoolean("isbeingedited");
                String responsible = select.getString("name");

                ccase.setId(id);
                ccase.setCaseName(title);
                ccase.setCaseDescription(description);
                ccase.setResponsible(responsible);
                ccase.setStatus(status);
                //ccase.setCaseSuspect(sal);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CaseHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        ccase.setCaseEvidence(this.getEvidenceList(id));
        return ccase;
    }

    /**
     * Method for updating case in database.
     *
     * @param c
     * @return
     */
    @Override
    public boolean updateCase(CriminalCase c) {
        System.err.println(c.getCaseDescription() + c.getCaseName() + c.getId() + "<------LOOOOOOOOOK HERE");
        String query = "UPDATE criminalcase SET title = '" + c.getCaseName()
                + "', description = '" + c.getCaseDescription() + "' WHERE id =" + c.getId() + ";";

        db.updateQuery(query);

        return db.updateQuery(query) == 1;
    }

    /**
     * Method for adding a case in database.
     *
     * @param c
     * @return 1
     */
    @Override
    public boolean addCase(CriminalCase c) {

        String query = String.format("INSERT INTO criminalcase (title, description, status, id, responsible) VALUES "
                + "('%s', '%s', '%s', '%s', '%s');", c.getCaseName(), c.getCaseDescription(),
                c.getStatus().toString(), c.getId(), c.getCaseSuspect().get(0).getDescription());

        db.updateQuery(query);

        System.out.println(String.format("Case %s added!", c.getId()));

        this.tempEvidenceList = c.getCaseEvidence();

        this.handleEvidence(tempEvidenceList, c.getId());

        return true;
    }

    /**
     * Method for updating Evidence in database from a list.
     *
     * @param evidence
     * @param caseRef
     */
    private void handleEvidence(List<Evidence> evidence, String caseRef) {

        if (!evidence.isEmpty()) {
            for (Evidence e : evidence) {
                String query = String.format("SELECT * FROM evidence WHERE id = '%s'", e.getId());
                ResultSet select = db.executeQuery(query);
                try {
                    if (!select.next()) {
                        this.addNewEvidence(e, caseRef);
                    } else {
                        this.updateEvidence(e);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CaseHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    /**
     * Method with SQL for adding new Evidence to Database.
     *
     * @param e
     * @param caseRef
     */
    private void addNewEvidence(Evidence e, String caseRef) {
        //IMPORTANT! REPLACE e.getLocation() with title when available!!!!!!
        String evidenceId = e.getId();

        String query = String.format("INSERT INTO evidence (title, description, id)\n"
                + "VALUES ('%s', '%s', '%s');", e.getTitle(), e.getDescription(), evidenceId);

        String refQuery = String.format("INSERT INTO caseevidenceref (caseid, evidenceid) "
                + "VALUES ('%s', '%s');", caseRef, evidenceId);

        db.updateQuery(query);
        db.updateQuery(refQuery);

        System.out.println(String.format("Evidence %s added!", e.getId()));

    }

    /**
     * Method for updating Evidence in database.
     *
     * @param e
     */
    private void updateEvidence(Evidence e) {
        String query = String.format("UPDATE evidence SET title = '%s', description = '%s' WHERE id = '%s';",
                e.getTitle(), e.getDescription(), e.getId());
        db.updateQuery(query);
    }

    /**
     * Method for getting a evidence list from database.
     *
     * @param CriminalCase
     * @return Evidence
     */
    private List<Evidence> getEvidenceList(String caseId) {

        List<Evidence> eviList = new ArrayList();
        Evidence evi;
        try {
            String query = "SELECT evidence.title, evidence.description, evidence.id FROM evidence "
                    + "JOIN caseevidenceref ON (evidence.id = caseevidenceref.evidenceId) "
                    + "WHERE caseevidenceref.caseId = " + "'17-11-40435-7'" + ";"; //HARDCODED ID UPDATE THIS!!!!

            ResultSet set = db.executeQuery(query);
            while (set.next()) {
                evi = new Evidence();
                evi.setTitle(set.getString("title"));
                evi.setDescription(set.getString("description"));
                evi.setId(set.getString("id"));
                eviList.add(evi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eviList;
    }

    @Override
    public boolean isCaseBeingEdited(String id) {
        String query = String.format("SELECT isbeingedited FROM criminalcase where id = '%s'", id);

        ResultSet select = db.executeQuery(query);
        boolean isBeingEdited = true;
        try {
            select.next();
            isBeingEdited = select.getBoolean(1);
        } catch (SQLException ex) {
            Logger.getLogger(CaseHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isBeingEdited;
    }

}
