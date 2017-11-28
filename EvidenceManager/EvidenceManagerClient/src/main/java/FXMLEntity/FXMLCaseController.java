
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.Evidence;
import io.swagger.client.model.Suspect;
import io.swagger.client.model.Token;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private IEntity connect; //For calling webservice methods in the ServerConnect implementation. 
    private CriminalCase cc; //Gets parsed from FXMLShowCaseScreenController.
    private Token token;
    
    
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
    @FXML
    private ChoiceBox<?> caseStatusCB;
   
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
        cc.setId(this.caseNrTF.getText());
        cc.setStatus(CriminalCase.StatusEnum.OPEN);
        
        //Change all this when YAML is updated so CriminalCase holds a responsible id
        ArrayList<Suspect> temp = new ArrayList();
        Suspect temps = new Suspect();
        temps.setDescription(this.token.getId());
        temp.add(temps);
        cc.setCaseSuspect(temp);
        
        
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
    public void initData(CriminalCase cc, Token token){
       if (cc != null) {
           this.buttonsToRemoveHB.getChildren().remove(this.addNewCaseBTN);
           this.cc = cc; //testcooment
           this.fillCase(cc);
           this.fillEvidence(cc.getCaseEvidence());
       } else {
           this.cc = new CriminalCase();
           this.buttonsToRemoveHB.getChildren().remove(this.saveChangesBTN);
           this.caseNrTF.setText(this.generateId());
       }
       this.token = token;
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
        this.cc.setStatus(CriminalCase.StatusEnum.OPEN);
        
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
       this.caseNrTF.setDisable(true);
       this.caseLawenforcerTF.setDisable(true);
       caseInfoTA.setText(this.cc.getCaseDescription());
       caseTitleTF.setText(this.cc.getCaseName());;;
       this.caseNrTF.setText(this.cc.getId());
       this.caseLawenforcerTF.setText(this.cc.getCaseSuspect().get(0).getDescription());
       
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
    
    /**
     * Fills the evidence listview with evidence from a list of evidence.
     * @param eList 
     */
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
    /**
     * Whe then 'edit evidence' button is pushed all textfields are set to editable.  
     * @param event 
     */
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
/**
 * When 'save changes' is pressed, the information found the evidence textfields are added to the evidence in the database.
 * @param event 
 */
    
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
    /**
     * Opens a separate window, where a new piece of evidence can be added.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleAddNewEvidenceAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewEvidence.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLNewEvidenceController controller = loader.<FXMLNewEvidenceController>getController();
        controller.initData(this);
        
        stage.show();
    }
    
    /**
     * If a piece of evidence is chosen from the evidence listview, the information is then stored in the respective textfields. 
     * @param event 
     */

    @FXML
    private void handleChooseEvidenceAction(MouseEvent event) {
        if (this.evidenceListLV.getSelectionModel().getSelectedItem() != null) {
            Evidence chosenEvidence = this.evidenceListLV.getSelectionModel().getSelectedItem();
            this.evidenceNrTF.setText(chosenEvidence.getId());
            this.evidenceDescriptionTA.setText(chosenEvidence.getDescription());
            this.evidenceLocationTF.setText(chosenEvidence.getLocation());
            this.evidenceCategoryTF.setText(chosenEvidence.getCategory());
            this.evidenceTitleTF.setText(chosenEvidence.getTitle());
            this.evidenceLawenforcerTF.setText(chosenEvidence.getPersonResponsible());
        }
    }
    /**
     * Calls the generateCaseId from the server.
     * @return the ID that has been generated. 
     */
    
    private String generateId() {
        try {
            return this.connect.generateCaseId();
        } catch (ApiException ex) {
            Logger.getLogger(FXMLCaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
   
}