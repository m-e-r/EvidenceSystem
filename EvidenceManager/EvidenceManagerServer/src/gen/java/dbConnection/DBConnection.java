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

    /**
     * Method for connecting to database.
     */
    public DBConnection() {
                
        //Used to connect to database.
        String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk:5432/si3_2017_group_13_db";
        String username = "si3_2017_group_13";
        String password = "grim26:bijou";

        try {

            con = DriverManager.getConnection(url, username, password);

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
            Statement st = con.createStatement();
            return st.executeQuery(query);

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
            Statement st = con.createStatement();
            return st.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
/*
    private void startConnection() {
        //Used to connect to database.
            try {
                if (this.con.isClosed()) {
                    this.connectionSetup();

                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
*/
    /*
    private void connectionSetup() {
        try {

            this.con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnection.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);

        }
    }
*/
}
