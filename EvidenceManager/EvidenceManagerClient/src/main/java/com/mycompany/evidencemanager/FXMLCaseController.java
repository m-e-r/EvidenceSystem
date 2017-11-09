
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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private ListView<Evidence> evidenceListLV;
    @FXML
    private TextArea caseInfoTA;
    @FXML
    private TextField evidenceCategoryTF;
    @FXML
    private TextField evidenceLawenforcerTF;
    @FXML
    private TextField evidenceLocationTF;
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
    private Button saveChangesBTN;
    @FXML
    private AnchorPane backPane;
    @FXML
    private SplitPane splitPane;
    @FXML
    private AnchorPane leftSplitPane;
    @FXML
    private HBox buttonsToRemoveHB;
    @FXML
    private TextField evidenceTitleTF;
    @FXML
    private TextField evidenceNrTF;
    @FXML
    private TextArea evidenceDescriptionTA;
    @FXML
    private Button editEvidenceBTN;
    @FXML
    private Button updateEvidenceBTN;
    @FXML
    private Button addNewEvidenceBTN;
   
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
        cc.setCaseDescription(this.caseInfoTA.getText());
        cc.setCaseName(this.caseTitleTF.getText());
        cc.setId(this.generateId());
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
       if (cc != null) {
           this.buttonsToRemoveHB.getChildren().remove(this.addNewCaseBTN);
           this.cc = cc;
           this.fillCase(cc);
           this.fillEvidence(cc.getCaseEvidence());
       } else {
           this.cc = new CriminalCase();
           this.buttonsToRemoveHB.getChildren().remove(this.saveChangesBTN);
       }
    }
    
    public void addNewEvidence(Evidence evi) {
        if (evi != null) {
            System.out.println("Tilføjet!");
            this.cc.addCaseEvidenceItem(evi);
            this.evidenceListLV.getItems().add(evi);
        }
    }
    
    /**
     * Instantiates a new CriminalCase object, whose attributes are set to be the attributes which the user wishes. 
     * @param event - Button that is pressed when the changes to a case is saved.
     * @throws ApiException 
     */
    @FXML
    private void saveChangesToCase(ActionEvent event) throws ApiException {
        this.cc.setCaseDescription(this.caseInfoTA.getText());
        this.cc.setCaseName(this.caseTitleTF.getText());
        
        this.connect.updateCase(this.cc);
        
         if(this.connect.updateCase(this.cc)){
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
//
//    public void editEvidence(){
//        String id;
//        String [] ids = evidenceListLV.getSelectionModel().getSelectedItem().split("\n");
//        
//        id = ids[0];
//        Evidence e = new Evidence();
//        
//        System.out.println(ids.toString());
//        
//    }
    
    
    private void fillEvidence (List<Evidence> eList){
       ObservableList<Evidence> occS = FXCollections.observableArrayList();
 
       
       /*Evidence e1 = new Evidence();
       e1.setEvidenceDescription("Herro m8");
       e1.setEvidenceNumber(1);
       e1.setLocation("Somewhere");
       */
       
       for(Evidence e : eList){
//           String adder = e.toString();
//           System.err.println(adder);
           occS.add(e);
       }
        
       evidenceListLV.setItems(occS);
 
    }

    @FXML
    private void handleEditEvidenceAction(ActionEvent event) {
        if (this.evidenceListLV.getSelectionModel().getSelectedItem() != null) {
            this.evidenceCategoryTF.setEditable(true);
            this.evidenceDescriptionTA.setEditable(true);
            this.evidenceLocationTF.setEditable(true);
            this.evidenceLawenforcerTF.setEditable(true);
            this.updateEvidenceBTN.setDisable(false);
            this.editEvidenceBTN.setDisable(true);
        }
    }

    @FXML
    private void handleSaveChangesAction(ActionEvent event) {
        if (this.evidenceListLV.getSelectionModel().getSelectedItem() != null) {
            //Disable and able fields and buttons
            this.evidenceCategoryTF.setEditable(false);
            this.evidenceDescriptionTA.setEditable(false);
            this.evidenceLocationTF.setEditable(false);
            this.evidenceLawenforcerTF.setEditable(false);
            this.editEvidenceBTN.setDisable(false);
            this.updateEvidenceBTN.setDisable(true);
            
            
            //Check for empty fields
            String description;
            String location;
            if (this.evidenceDescriptionTA.getText().trim().isEmpty()) {
                description = "Default description";
            } else {
                description = this.evidenceDescriptionTA.getText();
            }
            if (this.evidenceLocationTF.getText().trim().isEmpty()) {
                location = "Deafult location";
            } else {
                location = this.evidenceLocationTF.getText();
            }
            
            //Replace the existing Evidence on the case with the new modifed one
            String id = this.evidenceListLV.getSelectionModel().getSelectedItem().getId();
            
            for (int i = 0; i < this.cc.getCaseEvidence().size(); i++) {
                if (this.cc.getCaseEvidence().get(i).getId() == id) {
                    this.cc.getCaseEvidence().get(i).setDescription(description);
                    this.cc.getCaseEvidence().get(i).setLocation(location);
                }
            }
        }
    }

    @FXML
    private void handleAddNewEvidenceAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewEvidence.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLNewEvidenceController controller = loader.<FXMLNewEvidenceController>getController();
        controller.initData(this);
        
        stage.show();
    }

    @FXML
    private void handleChooseEvidenceAction(MouseEvent event) {
        if (this.evidenceListLV.getSelectionModel().getSelectedItem() != null) {
            Evidence chosenEvidence = this.evidenceListLV.getSelectionModel().getSelectedItem();
            this.evidenceNrTF.setText(chosenEvidence.getId());
            this.evidenceDescriptionTA.setText(chosenEvidence.getDescription());
            this.evidenceLocationTF.setText(chosenEvidence.getLocation());
        }
    }
    
    private String generateId() {
        StringBuilder str = new StringBuilder();
        int year = 17, month = 11, mod = 4096*16, body, check, adder = 0;
        long gen = System.currentTimeMillis(); //Replace with that linear congruate thing to run on the server with a long
                                              //enough cycle, that the same number will not be generated twice in a day.
                                             //(Since the date will be different, the number can be the same for different days).
        StringBuilder fullBody = new StringBuilder();
        
        //Generate the body part
        body = Math.abs((int) gen % mod);
        String stringBody = String.valueOf(body);
        while (stringBody.length() < 5) {
            stringBody += "0";
        }
        
        String stringFull = "" + year + month + stringBody;
        
        
        //Use full body to generate check value
        for (int i = 0; i < stringFull.length(); i++) {
            adder += (i+1)*Integer.parseInt(String.valueOf(stringFull.charAt(i)));
        }
        check = adder % 11;
        
        //Get ready for printing and then print
        fullBody.append(year)
            .append("-")
            .append(month)
            .append("-")
            .append(stringBody)
            .append("-")
            .append(check);
        
        return new String(fullBody);
    }
   
}