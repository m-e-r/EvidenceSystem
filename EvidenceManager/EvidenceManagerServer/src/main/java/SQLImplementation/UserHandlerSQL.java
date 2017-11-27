/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLImplementation;

import dbConnection.DBConnection;
import io.swagger.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.IUserHandlerSQL;

/**
 *
 * @author jacob
 */
public class UserHandlerSQL implements IUserHandlerSQL {
    
    private DBConnection db;
    
    public UserHandlerSQL(){
        this.db = new DBConnection();
    }

    @Override
    public boolean updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addUser(User user) {
        //int positionRef = user.getRole().ordinal();

        String query
                = String.format("INSERT INTO lawenforcer(name, id, positionref, username, passw, validated, address, birthday)\n"
                        + "VALUES ('%s', '%s', %d, '%s', '%s', FALSE, '%s', '%s')",
                        user.getName(), user.getEmployeeId(), 2, user.getUsername(), user.getPassword(), user.getAddress(), user.getBirthday());

        return this.db.updateQuery(query) == 1;
    }

    /**
     * Method used to get all users at the same location as the admin user who
     * views all users
     *
     * @param admin The lawenforcer object representing the admin user
     * @return Returns a list of lawenforcers at same location as admin
     */
    @Override
    public List<User> getListOfUsers(String admin) {
        List<User> allUsers = new ArrayList<>();
        User nextUser;
        String query = String.format("select * from lawenforcer where locationref "
                + "= (select _ref from locations where adress = '%s') AND validated = false;", admin);

        ResultSet select = db.executeQuery(query);

        try {
            while (select.next()) {
                String name = select.getString("name");
                String username = select.getString("username");
                String address = select.getString("address");
                String birthday = select.getString("birthday");
                int role = select.getInt("positionref");

                String queryPosition = String.format("SELECT title FROM lawenforcerposition WHERE _ref = %d;", role);
                ResultSet pos = db.executeQuery(queryPosition);
                pos.next();

                nextUser = new User();
                nextUser.setName(name);
                nextUser.setUsername(username);
                nextUser.setAddress(address);
                nextUser.setBirthday(birthday);
                nextUser.setRole(pos.getString(1));

                allUsers.add(nextUser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHandlerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allUsers;
    }

    /**
     * Sets a user to be validated.
     * @param username
     * @return 
     */
    @Override
    public boolean validateUser(String username, String newId) {

        String query = String.format("UPDATE public.lawenforcer\n"
                + "	SET validated=true, id = $s\n"
                + "	WHERE username = '%s';", newId, username);

        return this.db.updateQuery(query) == 1;

    }
    
}