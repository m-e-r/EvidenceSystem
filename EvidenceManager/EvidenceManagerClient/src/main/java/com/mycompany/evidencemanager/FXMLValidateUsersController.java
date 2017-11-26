package com.mycompany.evidencemanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLValidateUsersController implements Initializable {
   private ObservableList<UserType> roles;
   private ObservableList<User> users;
   private User user;
   private IServerConnect connect;

    @FXML
    private ListView<User> usersLV;
    @FXML
    private Button validateBTN;
    @FXML
    private TextArea addressTA;
    @FXML
    private ChoiceBox<UserType> rankCB;;
    @FXML
    private TextArea nameTA;
    @FXML
    private TextArea birthdayTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        this.roles = FXCollections.observableArrayList(UserType.values());
        this.rankCB.setItems(this.roles);
        
       try {
           this.users = FXCollections.observableArrayList(this.connect.getListOfUsers("Campusvej 55")); //Make initData method to get id from token
       } catch (ApiException ex) {
           Logger.getLogger(FXMLValidateUsersController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        this.usersLV.setItems(this.users);
    }    

    @FXML
    private void handleUserChoiceAction(MouseEvent event) {
        
        if(this.usersLV.getSelectionModel().getSelectedItem() != null) {
            this.validateBTN.setDisable(false);
            
            this.user = this.usersLV.getSelectionModel().getSelectedItem();
            
            this.nameTA.setText(this.user.getName());
            this.addressTA.setText(this.user.getAddress());
            this.birthdayTA.setText(this.user.getBirthday());
            this.rankCB.setValue(UserType.valueOf(this.user.getRole()));
        }
    }

    @FXML
    private void handleValidationAction(ActionEvent event) throws ApiException {
        
        if(this.connect.validateUser(this.user.getUsername())) {
            
            for (int i = 0; i < this.roles.size(); i++) {
                
                if(this.users.get(i).getUsername().equals(this.user.getUsername())) {
                    
                    this.users.remove(i);
                    
                    break;
                }
            }
            
            this.usersLV.setItems(this.users);
        }
        
    }
    
}