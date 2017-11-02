<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 6fe708a83770afb6a16077c83075738a862f0d0d
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
<<<<<<< HEAD
=======
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

   
}
=======
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
>>>>>>> 6fe708a83770afb6a16077c83075738a862f0d0d
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
    @FXML
    private Button removeEvidenceBTN;
    @FXML
    private Button addEvidenceBTN;
    @FXML
    private TextArea evidenceDescriptionTA;
    @FXML
    private TextField evidenceTitleTF;
   
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

    @FXML
    private void removeEvidence(ActionEvent event) {
    }

    @FXML
    private void addEvidence(ActionEvent event) {
    }

   
}
<<<<<<< HEAD
=======
>>>>>>> a11fdf3b1e43b0bb41c21e763047c7572aaef7be
>>>>>>> 6fe708a83770afb6a16077c83075738a862f0d0d
