package com.mycompany.evidencemanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.Evidence;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.control.ChoiceBox;
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
    private IServerConnect connect;
    private Evidence evidence;
    private FXMLCaseController controller;
    private ObservableList<String> categories;

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
    @FXML
    private ChoiceBox<String> evidenceCategoryCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        try {
            this.evidenceNumTF.setText(this.generateId());
        } catch (ApiException ex) {
            Logger.getLogger(FXMLNewEvidenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.evidenceNumTF.setDisable(true);
        this.evidenceTitleTF.requestFocus();
        
        this.categories = FXCollections.observableArrayList("Drugs", "Not Drugs");
        this.evidenceCategoryCB.setItems(this.categories);
        this.evidenceCategoryCB.setValue("Drugs");
    }    
    /**
     * Parses a FXMLCaseController
     * @param controller 
     */
    public void initData(FXMLCaseController controller) {
        this.controller = controller;
    } 
    /**
     * Saves the information about the new piece of evidence in a new evidence object.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleSaveAction(ActionEvent event) throws IOException {
        this.evidence = new Evidence();
        String description, location, title, resp;
        
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
        
        if (this.evidenceTitleTF.getText().trim().isEmpty()) {
            title = "Default Title";
        } else {
            title = this.evidenceTitleTF.getText();
        }
        
        if (this.evidenceRespTF.getText().trim().isEmpty()) {
            resp = "Default Personel Responsible";
        } else {
            resp = this.evidenceRespTF.getText();
        }
        
        this.evidence.setDescription(description);
        this.evidence.setId(this.evidenceNumTF.getText());
        this.evidence.setLocation(location);
        this.evidence.setTitle(title);
        this.evidence.setPersonResponsible(resp);
        this.evidence.setCategory(this.evidenceCategoryCB.getValue());
        this.goBack();
        Stage stage = (Stage) this.saveBTN.getScene().getWindow();
        stage.close();
    }

    /**
     * Adds the piece of evidence from the handleSaveAction method using the addnewEvidence method on another controller.
     * @param event 
     */
    @FXML
    private void handleDiscardAction(ActionEvent event) {
        this.controller.addNewEvidence(this.evidence);
    }
    
    
    private void goBack() throws IOException {
        this.controller.addNewEvidence(this.evidence);
    }
    
    /**
     * Returns a string ID from the generateEvidenceId method on the ServerConnect object. 
     * @return ID generated using the generateEvidenceId method.
     * @throws ApiException 
     */
    private String generateId() throws ApiException {
        return this.connect.generateEvidenceId();
    }
    
//    private String generateId() {
//        StringBuilder str = new StringBuilder();
//        int year = 17, month = 11, mod = 4096*16, body, check, adder = 0;
//        long gen = System.currentTimeMillis(); //Replace with that linear congruate thing to run on the server with a long
//                                              //enough cycle, that the same number will not be generated twice in a day.
//                                             //(Since the date will be different, the number can be the same for different days).
//        StringBuilder fullBody = new StringBuilder();
//        
//        //Generate the body part
//        body = Math.abs((int) gen % mod);
//        String stringBody = String.valueOf(body);
//        while (stringBody.length() < 5) {
//            stringBody += "0";
//        }
//        
//        String stringFull = "" + year + month + stringBody;
//        
//        
//        //Use full body to generate check value
//        for (int i = 0; i < stringFull.length(); i++) {
//            adder += (i+1)*Integer.parseInt(String.valueOf(stringFull.charAt(i)));
//        }
//        check = adder % 11;
//        
//        //Get ready for printing and then print
//        fullBody.append(year)
//            .append("-")
//            .append(month)
//            .append("-")
//            .append(stringBody)
//            .append("-")
//            .append(check);
//        
//        return new String(fullBody);
//    }
//    
    

}
