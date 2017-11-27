package com.mycompany.evidencemanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author jacob
 */
public class FXMLViewUserProfileController implements Initializable {

    @FXML
    private TextField idTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField birthdayTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField adressTF;
    @FXML
    private ChoiceBox<?> rankCB;
    @FXML
    private TextField stationTF;
    @FXML
    private RadioButton validatedRBTN;
    @FXML
    private ToggleGroup validateTG;
    @FXML
    private RadioButton nonValidatedRBTN;
    @FXML
    private Button editProfilBTN;
    
    private User user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void saveEditProfle(ActionEvent event) {
    }

    public void initData(User user) {
        this.user = user;
        this.nameTF.setText(this.user.getName());
        this.idTF.setText(this.user.getEmployeeId());
        this.birthdayTF.setText(this.user.getBirthday());
        this.usernameTF.setText(this.user.getUsername());
        this.passwordTF.setText(this.user.getPassword());
        this.adressTF.setText(this.user.getAddress());
        
    }
    
}
