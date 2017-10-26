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
public class dbConnection {

    private static Connection con = null;

    public dbConnection() {

        String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk:5432/si3_2017_group_13_db";
        String username = "si3_2017_group_13";
        String password = "grim26:bijou";

        try {

            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(dbConnection.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);

        }

    }

    public ResultSet executeQuery(String query) {

        try {
            Statement st = con.createStatement();
            return st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int updateQuery(String query) {

        try {
            Statement st = con.createStatement();
            return st.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

}
