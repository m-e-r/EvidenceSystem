package dbConnection;

import dbConnection.dbConnection;
import io.swagger.model.CriminalCase;
import io.swagger.model.Evidence;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class sqlStatement {

    private dbConnection db;

    public sqlStatement() {

        db = new dbConnection();
    }

    public boolean addCase(CriminalCase c) {

        String query = "INSERT INTO criminalcase (title, description) VALUES ('" + c.getCaseName() + "','" + c.getCaseDescription() + "');";

        return db.updateQuery(query) == 1;

    }

    public boolean updateCase(CriminalCase c) {

        String query = "UPDATE criminalcase SET title = '" + c.getCaseName() + "', description = '" + c.getCaseDescription() + "' WHERE _ref =" + c.getId() + ";";

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
