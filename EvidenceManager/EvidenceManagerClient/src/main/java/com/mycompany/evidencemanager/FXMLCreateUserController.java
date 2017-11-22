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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLCreateUserController implements Initializable {
    private IServerConnect connect;
    private ObservableList<UserType> roles;
    private User newUser;

    @FXML
    private TextField nameTF;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private ChoiceBox<UserType> roleCB;
    @FXML
    private Button checkUserNameBTN;
    @FXML
    private Button createUserBTN;
    @FXML
    private DatePicker birthdayDP;
    @FXML
    private Label missingLabel;
    @FXML
    private Label userNameTakenLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        this.newUser = new User();
        
        this.missingLabel.setVisible(false);
        this.userNameTakenLabel.setVisible(false);
        
        this.roles = FXCollections.observableArrayList(UserType.values());
        this.roleCB.setItems(this.roles);
        this.roleCB.setValue(UserType.POLICE_OFFICER);
    }    
    
    @FXML
    private void handleCreateUserAction(ActionEvent event) throws ApiException {
        if (this.fieldsAreNotNull()) {
            this.missingLabel.setVisible(false);
            
            this.newUser.setAddress(this.addressTF.getText());
            this.newUser.setBirthday(this.birthdayDP.getValue().toString());
            this.newUser.setName(this.nameTF.getText());
            this.newUser.setPassword(this.passwordTF.getText());
            this.newUser.setUsername(this.userNameTF.getText());
            this.newUser.setRole(this.roleCB.getValue());
            
            if (!this.connect.createNewUser(this.newUser)) {
                this.userNameTakenLabel.setVisible(true);
            } else {
                this.userNameTakenLabel.setVisible(false);
            }
        } else {
            this.missingLabel.setVisible(true);
        }
        
    }

    @FXML
    private void handleCheckUserNameAction(ActionEvent event) {
    }
    
    private boolean fieldsAreNotNull() {
        if (this.nameTF.getText().trim().isEmpty())
            return false;
        
        if (this.userNameTF.getText().trim().isEmpty())
            return false;
        
        if (this.passwordTF.getText().trim().isEmpty())
            return false;
        
        if (this.addressTF.getText().trim().isEmpty())
            return false;
        
        if (this.birthdayDP.getValue().toString() == null) //Ikke godt nok
            return false;
        
        return true;
    }


    
}