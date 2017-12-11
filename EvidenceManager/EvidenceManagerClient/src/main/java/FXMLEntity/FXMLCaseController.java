
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

import FXMLUser.IUser;
import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.CaseStatus;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.Evidence;
import io.swagger.client.model.Suspect;
import io.swagger.client.model.Token;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLCaseController implements Initializable {

    //Attributes
    private IEntity connect; //For calling webservice methods in the ServerConnect implementation. 
    private IUser userConnect;
    private CriminalCase cc; //Gets parsed from FXMLShowCaseScreenController.
    private Token token;
    private Date date;
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
    private ChoiceBox<CaseStatus> caseStatusCB;
    @FXML
    private Label caseAddedLBL;
    @FXML
    private Label caseNotAddedLBL;

    private ObservableList<CaseStatus> status;

    private String caseId = "";

    private boolean hasBeenChanged;
    @FXML
    private Label caseInfoLB;
    
    private boolean wasBeingEditededBeforeOpen;
    @FXML
    private Button assignPersonleBTN;
    
    private Thread t; //Thread used to autosave case every 2 minutes

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        this.userConnect = new ServerConnect();
        this.caseAddedLBL.setVisible(false);
        this.caseNotAddedLBL.setVisible(false);
        this.date = new Date();
        this.status = FXCollections.observableArrayList(CaseStatus.values());
        this.caseStatusCB.setItems(this.status);
        this.hasBeenChanged = false;
        

    }

    /**
     * Instantiates a new CriminalCase object, whose attributes are set to be
     * the attributes which the user wishes. The case is then added in the
     * database using the addCase method on the ServerConnect object.
     *
     * @param event - button that is pressed when a case is added.
     * @throws ApiException
     */
    @FXML
    private void addCase(ActionEvent event) throws ApiException {
        cc.setCaseDescription(this.caseInfoTA.getText());
        cc.setCaseName(this.caseTitleTF.getText());
        cc.setId(this.caseNrTF.getText());
        cc.setStatus(CaseStatus.OPEN.toString());
        cc.setToken(this.token);

        //Change all this when YAML is updated so CriminalCase holds a responsible id
        ArrayList<Suspect> temp = new ArrayList();
        Suspect temps = new Suspect();
        temps.setDescription(this.token.getId());
        temp.add(temps);
        cc.setCaseSuspect(temp);

        if (this.connect.addCase(cc)) {
            this.caseAddedLBL.setVisible(true);
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
        } else {
            this.caseNotAddedLBL.setVisible(true);
        }

    }

    /**
     * Method that is called when loading this stage.
     *
     * @param cc - CriminalCase object that is parsed across FXMLControllers.
     */
    public void initData(CriminalCase cc, Token token) throws ApiException {
        this.token = token;
        if (cc != null) {
            this.buttonsToRemoveHB.getChildren().remove(this.addNewCaseBTN);
            this.cc = cc;
            this.fillCase(cc);
            this.fillEvidence(cc.getCaseEvidence());
            this.checkBeingUpdated();
         
        } else {
            this.cc = new CriminalCase();
            this.buttonsToRemoveHB.getChildren().remove(this.saveChangesBTN);

            this.generateId();

        }
         
        this.initUpdateThread();
        this.t.start();
    }
    
    private void checkBeingUpdated() {
        this.cc.setToken(this.token);
        
        if(this.cc.isBeingUpdated()){
            this.caseInfoLB.setText("This case is currently being edited by another user."
                    + "\n Please wait until the case is saved and closed by the other user");
            this.caseInfoLB.setTextFill(Color.web("#ff0000"));
            this.lockAllFields();
            this.wasBeingEditededBeforeOpen = true;
        } else {
            this.cc.setIsBeingUpdated(true);
            try {
                this.updateCase();
            } catch (ApiException ex) {
                Logger.getLogger(FXMLCaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void lockAllFields(){
        this.backPane.setDisable(true);
        
    }

    public void addNewEvidence(Evidence evi) {
        if (evi != null) {
            System.out.println("Tilføjet!");
            this.cc.addCaseEvidenceItem(evi);
            this.evidenceListLV.getItems().add(evi);
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
        }
    }

    public void updateCase() throws ApiException {
        this.cc.setCaseDescription(this.caseInfoTA.getText());
        this.cc.setCaseName(this.caseTitleTF.getText());
        this.cc.setStatus(CaseStatus.OPEN.toString());

        boolean success = this.connect.updateCase(this.cc);

        if (success) {
            System.out.println("Succesful");
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
        } else {
            System.err.println("You're an idiot, try again");
        }
    }

    /**
     * Instantiates a new CriminalCase object, whose attributes are set to be
     * the attributes which the user wishes.
     *
     * @param event - Button that is pressed when the changes to a case is
     * saved.
     * @throws ApiException
     */
    @FXML
    private void saveChangesToCase(ActionEvent event) throws ApiException {
        this.hasBeenChanged = false;
        this.updateCase();
    }
    
    //Helper method to initialize thread t. This set a thread that saves changes
    //and sleeps for 2 minutes. 
    private void initUpdateThread(){
        this.t = new Thread(() -> {
            while(true){
            this.saveChangesBTN.fire();
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                return;
                
            }
            }
        });
    }

    /**
     * Called from initData, when editCase is pressed. Updates all textfields
     * and textareas with the information pertaining to the case that is to be
     * edited.
     *
     * @param cc
     */
    private void fillCase(CriminalCase cc) throws ApiException {
        this.caseNrTF.setDisable(true);
        this.caseLawenforcerTF.setDisable(true);
        caseInfoTA.setText(this.cc.getCaseDescription());
        caseTitleTF.setText(this.cc.getCaseName());
        this.caseNrTF.setText(this.cc.getId());
        System.out.println("TOKEN:  " + this.token);
        this.caseLawenforcerTF.setText(this.userConnect.getUser(this.cc.getResponsible(), this.token).getName());
        this.caseStatusCB.setValue(CaseStatus.fromValue(this.cc.getStatus()));

//       if(this.cc.getStatus().equals(this.cc.getStatus().OPEN)){
//          statusRBTN.setSelected(true);
//       } else {
//           statusRBTN.setSelected(false);
//       }
        caseNrTF.setText(String.valueOf(this.cc.getId()));
        
        this.addTextListeners();

    }

    /**
     * Helper method that creates listeners to the case text fields and areas
     * Sets a boolean to true, that something has been changes, which prompts the
     * user to save. 
     */
    private void addTextListeners() {
        caseTitleTF.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!oldValue.equals(newValue)) {
                hasBeenChanged = true;
            }
        });

        caseInfoTA.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!oldValue.equals(newValue)) {
                hasBeenChanged = true;
            }
        });

        caseLawenforcerTF.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!oldValue.equals(newValue)) {
                hasBeenChanged = true;
            }
        });

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
     *
     * @param eList
     */
    private void fillEvidence(List<Evidence> eList) {
        ObservableList<Evidence> occS = FXCollections.observableArrayList();

        /*Evidence e1 = new Evidence();
       e1.setEvidenceDescription("Herro m8");
       e1.setEvidenceNumber(1);
       e1.setLocation("Somewhere");
         */
        for (Evidence e : eList) {
//           String adder = e.toString();
//           System.err.println(adder);
            occS.add(e);
        }

        evidenceListLV.setItems(occS);

    }

    /**
     * Whe then 'edit evidence' button is pushed all textfields are set to
     * editable.
     *
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
     * When 'save changes' is pressed, the information found the evidence
     * textfields are added to the evidence in the database.
     *
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
                if (this.cc.getCaseEvidence().get(i).getId().equals(id)) {
                    this.cc.getCaseEvidence().get(i).setDescription(description);
                    this.cc.getCaseEvidence().get(i).setLocation(location);
                }
            }
        }
    }

    /**
     * Opens a separate window, where a new piece of evidence can be added.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleAddNewEvidenceAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewEvidence.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLNewEvidenceController controller = loader.<FXMLNewEvidenceController>getController();
        controller.initData(this, this.token);
        stage.setTitle("Logged in as " + token.getName());
        stage.show();
    }

    /**
     * If a piece of evidence is chosen from the evidence listview, the
     * information is then stored in the respective textfields.
     *
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
     *
     * @return the ID that has been generated.
     */
    private void generateId() {

        new Thread(() -> {
            try {
                this.caseId = this.connect.generateCaseId(this.token);
                this.caseNrTF.setText(this.caseId);
            } catch (ApiException ex) {
                Logger.getLogger(FXMLCaseController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }).start();

    }
    
    public CriminalCase getCase(){
        return this.cc;
    }

    public boolean hasBeenChanged() {
        return this.hasBeenChanged;
    }
    
    public boolean wasBeingEditedBeforeOpen(){
        return this.wasBeingEditededBeforeOpen;
    }
    
    public void interuptUpdateThread(){
        this.t.interrupt();
    }

    @FXML
    private void handleOpenAssignPersonelAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AssignPersonel.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLAssignPersonelController controller = loader.<FXMLAssignPersonelController>getController();
        controller.initData(this.token);
        stage.setTitle("Logged in as " + token.getName());
        stage.show();
    }

}
