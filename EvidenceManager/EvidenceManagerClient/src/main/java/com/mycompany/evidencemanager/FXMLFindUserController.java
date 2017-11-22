/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

import io.swagger.client.model.LawEnforcer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jacob
 */
public class FXMLFindUserController implements Initializable {

    @FXML
    private TextField searchTF;
    @FXML
    private TableView<LawEnforcer> usersTV;
    @FXML
    private Button searchBTN;
    @FXML
    private Button updateBTN;
    @FXML
    private TableColumn<LawEnforcer, String> TVidCol;
    @FXML
    private TableColumn<LawEnforcer, String> TVNameCol;
    @FXML
    private TableColumn<LawEnforcer, String> TVRankCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }
    
}
