/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLUser;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class Shows list of users with same location as admin logged
 * in
 *
 * @author jacob
 */
public class FXMLFindUserController implements Initializable {

    @FXML
    private TextField searchTF;
    @FXML
    private TableView<User> usersTV;
    @FXML
    private Button updateBTN;
    @FXML
    private TableColumn<User, String> TVidCol;
    @FXML
    private TableColumn<User, String> TVNameCol;
    @FXML
    private TableColumn<User, String> TVRankCol;
    @FXML
    private Button viewBTN; 
    @FXML
    private Button createUser;

    private IUser connect;
    private ObservableList<User> userList;
    private User admin;
    private Token token;
    private Date date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.connect = new ServerConnect();
       this.date = new Date();
    }    



    @FXML
    private void update(ActionEvent event) {
        setUserList();
    }

    /**
     * Method that sets the tableview with all the user, that has the same
     * adress as the logged in admin
     */
    private void setUserList() {
        List<User> users = null;
        try {
            users = connect.getListOfUsers(this.token);
        } catch (ApiException ex) {
            Logger.getLogger(FXMLFindUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (users != null) {
            TVidCol.setCellValueFactory(new PropertyValueFactory<User, String>("employeeId"));
            TVNameCol.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
            TVRankCol.setCellValueFactory(new PropertyValueFactory<User, String>("role"));

            usersTV.setItems(userList);
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
        }
    }

    @FXML
    private void viewUser(ActionEvent event) throws IOException, ApiException {
        User selectedUser = this.usersTV.getSelectionModel().getSelectedItem();       
        this.showUserScreenStage(selectedUser, this.token);
    }

    /**
     * Displays the view user screen.
     *
     * @param connector not relevant
     * @return stage.
     * @throws IOException
     */
    private Stage showUserScreenStage(User user, Token t) throws IOException, ApiException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewUserProfile.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLViewUserProfileController controller = loader.<FXMLViewUserProfileController>getController();
        controller.initData(user, t);
        stage.show();
        return stage;
    }

    private Stage showCreateUserScreenStage(Token t) throws IOException, ApiException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreateUser.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLCreateUserController controller = loader.<FXMLCreateUserController>getController();
        controller.initData(token);
        stage.show();
        return stage;
    }
    
    

    public void initData(Token token) {
        this.token = token;
        this.setUserList();
    }


    @FXML
    private void createUser(ActionEvent event) throws IOException, ApiException {
        this.showCreateUserScreenStage(token);
    }

}
