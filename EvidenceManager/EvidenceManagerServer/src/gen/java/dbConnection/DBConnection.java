package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruger
 */
public class DBConnection {

    private static Connection con = null;

    private final String URL = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk:5432/si3_2017_group_13_db";
    private final String USERNAME = "si3_2017_group_13";
    private final String PASSWORD = "grim26:bijou";

    /**
     * Method for connecting to database.
     */
    public DBConnection() {
        if (con == null) {
            createConnection();
        }

    }
    //Used to connect to database.
    private void createConnection() {
        
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnection.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);

        }
    }

    /**
     * Method for executing sql statements written in strings.
     *
     * @param query
     * @return
     */
    public ResultSet executeQuery(String query) {

        try {
            if (con.isValid(0)) {
                Statement st = con.createStatement();
                return st.executeQuery(query);
            }
            createConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method for updating data in database.
     *
     * @param query
     * @return
     */
    public int updateQuery(String query) {

        try {
            if (con.isValid(0)) {
                Statement st = con.createStatement();
                return st.executeUpdate(query);
            }
            createConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}