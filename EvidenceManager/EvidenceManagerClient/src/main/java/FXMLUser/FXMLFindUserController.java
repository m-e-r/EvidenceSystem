/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLUser;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.api.SecurityApi;
import io.swagger.client.model.LawEnforcer;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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
 * FXML Controller class
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

    private IUser connect;
    private ObservableList<User> userList;
    private User admin;
    @FXML
    private Button viewBTN;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.connect = new ServerConnect();
       this.admin = new User();
       this.admin.setAddress("Campusvej 55"); 
       this.setUserList();
    }    


    @FXML
    private void update(ActionEvent event) {
        setUserList();
    }
    
    /**
     * Method that sets the tableview with all the user, that has the same adress as the logged in admin
     */
    private void setUserList(){
        try {
            String address = admin.getAddress();
            userList = FXCollections.observableArrayList(connect.getListOfUsers(address));
            for(User s : userList) {
                System.out.println(s.getRole());
                UserType us = UserType.valueOf(s.getRole());
                System.out.println(us);
            }
            
            TVidCol.setCellValueFactory(new PropertyValueFactory<User, String>("employeeId"));
            TVNameCol.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
            TVRankCol.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
            
            usersTV.setItems(userList);
            
            
        } catch (ApiException ex) {
            Logger.getLogger(FXMLFindUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @FXML
    private void viewUser(ActionEvent event) throws IOException, ApiException {
        User selectedUser = this.usersTV.getSelectionModel().getSelectedItem();
        this.showUserScreenStage(selectedUser);
        
    }
    
    /**
     * Displays the view user screen.
     *
     * @param connector not relevant
     * @return stage.
     * @throws IOException
     */
    private Stage showUserScreenStage(User user) throws IOException, ApiException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewUserProfile.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLViewUserProfileController controller = loader.<FXMLViewUserProfileController>getController();
        controller.initData(user);
        stage.show();
        return stage;
    }
    
    
    
}
