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
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLCaseController implements Initializable {
    private IServerConnect connect;
    private CriminalCase cc;
    
    
    @FXML
    private TextField caseNrTF;
    @FXML
    private ListView<?> evidenceListLV;
    @FXML
    private TextArea caseInfoTA;
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
    @FXML
    private RadioButton statusRBTN;
    @FXML
    private ToggleGroup toggler;
    @FXML
    private Button saveChangesBTN;
   
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
    
   
    public void initData(CriminalCase cc){
        this.cc = cc;
        this.fillCase(cc);
        
    }
    
     @FXML
    private void saveChangesToCase(ActionEvent event) throws ApiException {
        CriminalCase changedCriminalCase = new CriminalCase();
        changedCriminalCase.setCaseDescription(this.caseInfoTA.getText());
 
        changedCriminalCase.setCaseName(this.caseTitleTF.getText());
        changedCriminalCase.setId(Integer.parseInt(this.caseNrTF.getText()));
        
        this.connect.updateCase(changedCriminalCase);
        
         if(this.connect.updateCase(changedCriminalCase)){
            System.out.println("Succesful");
        } else {
            System.err.println("You're an idiot, try again");
        }
    
    }
    
    private void fillCase(CriminalCase cc){
       caseInfoTA.setText(this.cc.getCaseDescription());
       caseTitleTF.setText(this.cc.getCaseName());
       
//       if(this.cc.getStatus().equals(this.cc.getStatus().OPEN)){
//          statusRBTN.setSelected(true);
//       } else {
//           statusRBTN.setSelected(false);
//       }
        caseNrTF.setText(String.valueOf(this.cc.getId()));
        
    }

   
}
