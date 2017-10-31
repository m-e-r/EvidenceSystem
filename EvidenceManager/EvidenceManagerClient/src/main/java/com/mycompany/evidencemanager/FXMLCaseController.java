/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.CriminalCase;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLCaseController implements Initializable {
    private IServerConnect connect;

    @FXML
    private TextField caseNrTF;
    @FXML
    private ListView<?> evidenceListLV;
    @FXML
    private TextArea caseInfoTA;
    @FXML
    private RadioButton activeRBTN;
    @FXML
    private RadioButton inactiveRBTN;
    @FXML
    private TextField evidenceCategoryTF;
    @FXML
    private TextField evidenceLawenforcerTF;
    @FXML
    private TextField evidenceLocationTF;
    @FXML
    private RadioButton digialRBTN;
    @FXML
    private RadioButton physicalRBTN;
    @FXML
    private TextField caseLawenforcerTF;
    @FXML
    private TextField primeSuspectTF;
    @FXML
    private TextField additionelSuspectTF;
    @FXML
    private TextField caseCategoryTF;
    @FXML
    private Button addSuspectBTN;
    @FXML
    private TextField caseTitleTF;
    @FXML
    private Button addNewCaseBTN;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.connect = new ServerConnect();


    }    



    @FXML
    private void caseActive(ActionEvent event) {
    }

    @FXML
    private void caseInactive(ActionEvent event) {
    }


    @FXML
    private void evidenceNrAdd(ActionEvent event) {
    }

    @FXML
    private void evidenceCategory(ActionEvent event) {
    }

    @FXML
    private void evidenceLawenforcer(ActionEvent event) {
    }

    @FXML
    private void evidenceLocation(ActionEvent event) {
    }

    @FXML
    private void digitalEvidence(ActionEvent event) {
    }

    @FXML
    private void physicalEvidence(ActionEvent event) {
    }


    @FXML
    private void addCase(ActionEvent event) throws ApiException {
        CriminalCase cc = new CriminalCase();
        cc.setCaseDescription(this.caseInfoTA.getText());
        cc.setCaseName(this.caseTitleTF.getText());
        cc.setId(Integer.parseInt(this.caseNrTF.getText()));
        cc.setStatus(CriminalCase.StatusEnum.OPEN);
        
        
        if(this.connect.addCase(cc)){
            System.out.println("Succesful");
            
        } else {
            System.err.println("You're an idiot, try again");
        }
     
    }


    @FXML
    private void lawenforcer(ActionEvent event) {
    }

    @FXML
    private void caseNrAdd(ActionEvent event) {
    }

    @FXML
    private void primeSuspect(ActionEvent event) {
    }

    @FXML
    private void addtionalSuspect(ActionEvent event) {
    }

    @FXML
    private void caseCategory(ActionEvent event) {
    }

    @FXML
    private void addSuspect(ActionEvent event) {
    }
    
   
    public void initData(IServerConnect isc){
    }
}
