package dbConnection;

import security.IUserSql;
import io.swagger.api.impl.IsqlStatement;
import io.swagger.model.CriminalCase;
import io.swagger.model.CriminalCaseMap;
import io.swagger.model.Evidence;
import io.swagger.model.LawEnforcer;
import io.swagger.model.Suspect;
import io.swagger.model.User;
import io.swagger.model.UserType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.SecureSql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruger
 */
public class SQLStatement implements IsqlStatement, SecureSql, IUserSql {

    private List<Evidence> tempEvidenceList;

    private DBConnection db;

    public SQLStatement() {

        db = new DBConnection();
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
                    Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.println("Fra updateEvidence");
        //IMPORTANT! REPLACE e.getLocation() with title when available!!!!!!
        String query = String.format("UPDATE evidence SET title = '%s', description = '%s' WHERE id = '%s';",
                e.getTitle(), e.getDescription(), e.getId());
        db.updateQuery(query);

        System.out.println(String.format("Evidence %s updated!", e.getId()));
    }

    /**
     * Method to edit a piece of evidence. Updates a piece of evidence using an
     * evidence object.
     *
     * @param e The evidence with updated variables.
     */
    @Override
    public void editEvidence(Evidence e) {
        updateEvidence(e);
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
     * Mehtod for getting a case from database.
     *
     * @param Id
     * @return CriminalCase
     */
    @Override
    public CriminalCase getCase(int id) {

        CriminalCase ccase = new CriminalCase();

        try {                                                                       //HARDCODED ID CHANGE THIS
            String query = "SELECT id, title, description FROM criminalcase WHERE id =' " + id + "'";

            ResultSet set = db.executeQuery(query);
            List<Suspect> sal = new ArrayList<>();
            Suspect s = new Suspect();
            s.setDescription("Kasper");
            sal.add(s);

            while (set.next()) {

                ccase.setId(set.getString("id"));
                ccase.setCaseName(set.getString("title"));
                ccase.setCaseDescription(set.getString("description"));
                ccase.setCaseSuspect(sal);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        ccase.setCaseEvidence(this.getEvidenceList(id));
        return ccase;
    }

    /**
     * Method for getting a evidence list from database.
     *
     * @param CriminalCase
     * @return Evidence
     */
    private List<Evidence> getEvidenceList(int caseId) {

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
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eviList;
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
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return evidence;

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
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * Method to get the case id of the latest inserted case in the database. 
     * Should be used to ??
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
     * Method to get the evidence id of the latest inserted evidence in the database. 
     * Should be used to ??
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
     * Method to update the latest case id in the database. Should be called whenever a
     * new case is added.
     * @param id The newest id as a string.
     */
    @Override
    public void updateCaseId(String id) {
        String query = "UPDATE latestid\n SET caseid= " + "'" + id + "'";
        db.updateQuery(query);
    }

    /**
     * Method to update the latest evidence id in the database. Should be called whenever a
     * new evidence is added.
     * @param id The newest id as a string.
     */
    @Override
    public void updateEvidenceId(String id) {
        String query = "UPDATE latestid\n"
                + "   SET evidenceid=" + "'" + id + "'";

        db.updateQuery(query);
    }

    /**
     * Method to get the rank of a user from the database. 
     * Select the rank from database corrosponding to an id
     * @param id The id of the user from who we want to get the rank
     * @return The rank of the found user as a String
     */
    @Override
    public String getRank(String id) {
        System.out.println(id);

        String query = String.format("select title from lawenforcerposition where _ref = (SELECT positionref from lawenforcer where id = '%s')", id);

        ResultSet select = db.executeQuery(query);
        
        String position = null;
        int i = 1;
        try {
            while(select.next() | i ==1) {
                position = select.getString("title");
                System.out.println(position);
                i++;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return position;

    }

    /**
     * Method to update the latest user id in the database table latestid.
     * @param id The newest user id
     */
    @Override
    public void updateUserId(String id) {
        String query = String.format("UPDATE latestid set lawenforcerId = '%s';", id);
        db.updateQuery(query);
    }

    /**
     * Method to get the latest added userid in the database.
     * @param valueFromEnum A string representing the usertype enum value, from the UserType enum from the client
     *  This should be one of the toStrings from the userype enum.
     * @return  Returns the latest id from the specified usertype in the database
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
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return latestId;
    }

    
    /**
     * Method to check wether a user exists in the database using a username and a password
     * @param username The username of a user as a string
     * @param password The password of a user as a string
     * @return returns true if the user exists in the database, false if not. 
     */
    @Override
    public boolean getPassAndName(String username, String password) {

        String query = "select username, passw from lawenforcer where username = '" 
                + username + "' and passw = '" + password + "'";


        ResultSet select = db.executeQuery(query);
        
        try {
            return select.next();
        } catch (SQLException ex) {
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Method to get the id of a lawenforcer from the database
     * @param username The username of the lawenforcer whoese id should be found
     * @param password The password of the lawenforcer whoese id should be found
     * @return The lawenforcerid found, as a string. 
     */
    @Override
    public String getLawEnforcerId(String username, String password) {

        String id = null;

        String query = "Select id from lawenforcer where username = '" + username + "' and passw = '" + password + "'";

        ResultSet select = db.executeQuery(query);

        try {
            while (select.next()) {
                id = select.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;

    }


    /**
     * Method used to get all users at the same location as the admin user who
     * views all users
     * @param admin The lawenforcer object representing the admin user
     * @return Returns a list of lawenforcers at same location as admin
     */
    @Override
    public List<User> getListOfUsers(String admin) {
        List<User> allUsers = new ArrayList<>();
        User nextUser;
        String query = String.format("select * from lawenforcer where locationref "
                + "= (select _ref from locations where adress = '%s');", admin);
        
        ResultSet select = db.executeQuery(query);
        
        try {
            while (select.next()) {
                String name = select.getString("name");
                String id = select.getString("id");
                int role = select.getInt("positionref");
                
                String queryPosition = String.format("SELECT title FROM lawenforcerposition WHERE _ref = %d", role);
                ResultSet pos = db.executeQuery(queryPosition);
                pos.next();
                
                nextUser = new User();
                nextUser.setName(name);
                nextUser.setEmployeeId(id);
                nextUser.setRole(pos.getString(1));
                
                allUsers.add(nextUser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allUsers;
    }
        

    @Override
    public boolean addUser(User user) {
        //int positionRef = user.getRole().ordinal();
        
        String query = 
        String.format("INSERT INTO lawenforcer(name, id, positionref, username, passw, validated, address, birthday)\n" +
        "VALUES ('%s', '%s', %d, '%s', '%s', FALSE, '%s', '%s')", 
        user.getName(), user.getEmployeeId(), 2, user.getUsername(), user.getPassword(), user.getAddress(), user.getBirthday());
        
        return this.db.updateQuery(query) == 1;
    }

    


}
