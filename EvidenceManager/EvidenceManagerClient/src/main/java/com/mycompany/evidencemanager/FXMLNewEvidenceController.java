package com.mycompany.evidencemanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.model.Evidence;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLNewEvidenceController implements Initializable {
    private Evidence evidence;
    private FXMLCaseController controller;

    @FXML
    private TextField evidenceNumTF;
    @FXML
    private TextField evidenceCatTF;
    @FXML
    private TextField evidenceLocTF;
    @FXML
    private TextField evidenceRespTF;
    @FXML
    private TextField evidenceTitleTF;
    @FXML
    private TextArea evidenceDescTA;
    @FXML
    private Button saveBTN;
    @FXML
    private Button discardBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initData(FXMLCaseController controller) {
        this.controller = controller;
    } 

    @FXML
    private void handleSaveAction(ActionEvent event) throws IOException {
        this.evidence = new Evidence();
        String description, location;
        
        if (this.evidenceDescTA.getText().trim().isEmpty()) {
            description = "Default Description";
        } else {
            description = this.evidenceDescTA.getText();
        }
        
        if (this.evidenceLocTF.getText().trim().isEmpty()) {
            location = "Default Location";
        } else {
            location = this.evidenceLocTF.getText();
        }
        
        this.evidence.setEvidenceDescription(description);
        this.evidence.setEvidenceNumber(0);
        this.evidence.setLocation(location);
        this.goBack();
        Stage stage = (Stage) this.saveBTN.getScene().getWindow();
        stage.close();
    }

    
    @FXML
    private void handleDiscardAction(ActionEvent event) {
        this.controller.addNewEvidence(this.evidence);
    }
    
    
    private void goBack() throws IOException {
        this.controller.addNewEvidence(this.evidence);
    }

}
