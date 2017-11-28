/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

import FXMLEntity.FXMLCaseController;
import FXMLUser.FXMLValidateUsersController;
import FXMLUser.FXMLViewUserProfileController;
import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.CriminalCase;
import io.swagger.client.model.Token;
import io.swagger.client.model.UserType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author march
 */
public class FXMLShowCaseScreenController implements Initializable {
    //Attributes
    private IEntity connect; //Used for calling methods on the server
    private ObservableList<String> occ; //Used for holding case name and id for displaying in the ListView
    private Button valiBTN;
    private Token token;
    
    @FXML
    private ListView<String> caseEditLV;
    @FXML
    private TextField caseSearchTF;
    @FXML
    private Button editCaseBTN;
    @FXML
    private Button addCaseBTN;
    @FXML
    private Button malplacedSearchBTN;
    @FXML
    private HBox buttonsHB;
    @FXML
    private Button viewProfileBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.connect = new ServerConnect();
        this.occ = FXCollections.observableArrayList();
    }
    
    /**
     * Loads into the ListView all the case names/ids relevant to the logged in user.
     * Should be called from the initData method, NOT initialize.
     * @param employeeId the user who logs in
     * @throws ApiException 
     */
    private void showsRelevantCases() throws ApiException {
        Map<String, String>tempMap = this.connect.getCases(this.token.getId());
//        Map<String, String> tempMap = new HashMap();
//        
//        tempMap.put("14323", "Malte is the killer");
//        tempMap.put("432454", "Malte is the real killer");
//        tempMap.put("343242", "Malte did it");
        for (String s : tempMap.keySet()) {
            String adder = s + "\n" + tempMap.get(s);
            this.occ.add(adder);
        }
        
        //Create validate user button if correct rank
        //if (this.token.getUsertype().equals(UserType.COMISSIONER.toString().toUpperCase())) {
        if (UserType.valueOf(this.token.getUsertype()).equals(UserType.COMISSIONER)) {
            this.valiBTN = new Button();
            this.valiBTN.setText("Validate\nNew Users");
            //Remember to do check if new users need validation when available in the API
            
            this.buttonsHB.getChildren().add(valiBTN);
            this.setValidateAction();
        }

        this.caseEditLV.setItems(this.occ);
    }
    
    private void setValidateAction() {
        this.valiBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("heyyo");
                try {
                    showValidationStage();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLShowCaseScreenController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ApiException ex) {
                    Logger.getLogger(FXMLShowCaseScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private Stage showValidationStage() throws IOException, ApiException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ValidateUsers.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLValidateUsersController controller = loader.<FXMLValidateUsersController>getController();
        stage.show();
        return stage;
    }
    
    /**
     * Method to be called when this stage is loaded.
     * @param employee
     */
    public void initData(Token employee) throws ApiException {
        this.token = employee;
        this.showsRelevantCases();
    }
    
    /**
     * Displays the selected CriminalCase from the ListView.
     * @param event the editCase button.
     * @return Shows the new Stage
     * @throws IOException
     * @throws ApiException 
     */
    @FXML
    private Stage editCase(ActionEvent event) throws IOException, ApiException {
        String id;
        String [] ids = caseEditLV.getSelectionModel().getSelectedItem().split("\n");
        
        id = ids[0];
        CriminalCase cc;
        
        cc = this.connect.getCase(id);
        System.err.println(cc.toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLCaseController controller = loader.<FXMLCaseController>getController();
        controller.initData(cc, this.token);
        
        stage.show();
        return stage;  
}
    
    /**
     * Displays the screen where a user can add a new CriminalCase.
     * @param event the addCase button
     * @return Shows the new Stage
     * @throws IOException 
     */
    @FXML
    private Stage addCase(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLCaseController controller = loader.<FXMLCaseController>getController();
        controller.initData(null, this.token);
        
        stage.show();
        return stage;

    }

//    @FXML
//    private void viewProfile(ActionEvent event) throws IOException{
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewUserProfile.fxml"));
//
//        Stage stage = new Stage(StageStyle.DECORATED);
//        stage.setScene(new Scene((Pane) loader.load()));
//
//        FXMLViewUserProfileController controller = loader.<FXMLViewUserProfileController>getController();
//        controller.initData(null, this.token);
//        
//        stage.show();
//        return stage;
//        
//    }




}
