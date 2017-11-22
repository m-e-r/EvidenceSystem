package com.mycompany.evidencemanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

    @FXML
    private ListView<?> usersLV;
    @FXML
    private Button validateBTN;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextArea addressTA;
    @FXML
    private TextField lastNameTF;
    @FXML
    private ChoiceBox<?> rankCB;;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleUserChoiceAction(MouseEvent event) {
    }

    @FXML
    private void handleValidationAction(ActionEvent event) {
    }
    
}
