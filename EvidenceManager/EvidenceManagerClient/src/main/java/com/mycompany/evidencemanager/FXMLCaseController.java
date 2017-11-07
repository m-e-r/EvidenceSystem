
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.Evidence;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    //Attributes
    private IServerConnect connect; //For calling webservice methods in the ServerConnect implementation. 
    private CriminalCase cc; //Gets parsed from FXMLShowCaseScreenController. 
    
    
    @FXML
    private TextField caseNrTF;
    @FXML
    private ListView<String> evidenceListLV;
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

    
    /**
     * Instantiates a new CriminalCase object, whose attributes are set to be the attributes which the user wishes. 
     * The case is then added in the database using the addCase method on the ServerConnect object.
     * @param event - button that is pressed when a case is added.
     * @throws ApiException 
     */
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


    
    /**
     * Method that is called when loading this stage.
     * @param cc - CriminalCase object that is parsed across FXMLControllers. 
     */
    public void initData(CriminalCase cc){
        this.cc = cc;
        this.fillCase(cc);
        this.fillEvidence(cc.getCaseEvidence());
    }
    
    /**
     * Instantiates a new CriminalCase object, whose attributes are set to be the attributes which the user wishes. 
     * @param event - Button that is pressed when the changes to a case is saved.
     * @throws ApiException 
     */
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
    
    /**
     * Called from initData, when editCase is pressed. 
     * Updates all textfields and textareas with the information pertaining to the case that is to be edited.
     * @param cc 
     */
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

    public void editEvidence(){
        String id;
        String [] ids = evidenceListLV.getSelectionModel().getSelectedItem().split("\n");
        
        id = ids[0];
        Evidence e = new Evidence();
        
        System.out.println(ids.toString());
        
    }
    
    
    private void fillEvidence (List<Evidence> eList){
       ObservableList<String> occS = FXCollections.observableArrayList();
 
       
       /*Evidence e1 = new Evidence();
       e1.setEvidenceDescription("Herro m8");
       e1.setEvidenceNumber(1);
       e1.setLocation("Somewhere");
       */
       
       for(Evidence e : eList){
           String adder = e.toString();
           System.err.println(adder);
           occS.add(adder);
       }
        
       evidenceListLV.setItems(occS);
       
    
    }
   
}