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
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author march
 */
public class FXMLShowCaseScreenController implements Initializable {

    //Attributes
    private IEntity connect; //Used for calling methods on the server
    private ObservableList<String> occ; //Used for holding case name and id for displaying in the ListView
    private ObservableList<String> tempCaseList;
    private Button valiBTN;
    private Token token;
    private Date date;
    private NewsHandler newsHandler;
    private ObservableList<News> newsToShow;

    @FXML
    private ListView<String> caseEditLV;
    @FXML
    private TextField caseSearchTF;
    @FXML
    private Button editCaseBTN;
    @FXML
    private Button addCaseBTN;
    @FXML
    private HBox buttonsHB;
    @FXML
    private Button viewProfileBTN;
    @FXML
    private Label caseNotEditedLBL;
    @FXML
    private Button searchBTN;
    @FXML
    private ListView<News> newsLV;
    @FXML
    private TextArea selectedNewsTA;
    @FXML
    private Button logoutBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.caseNotEditedLBL.setVisible(false);
        this.connect = new ServerConnect();
        this.occ = FXCollections.observableArrayList();

        this.date = new Date();
        this.newsHandler = new NewsHandler();
        this.newsToShow = FXCollections.observableArrayList(this.newsHandler.getNews());
        this.newsLV.setItems(this.newsToShow);
    }

    /**
     * Loads into the ListView all the case names/ids relevant to the logged in
     * user. Should be called from the initData method, NOT initialize.
     *
     * @param employeeId the user who logs in
     * @throws ApiException
     */
    private void showsRelevantCases() throws ApiException {
        Map<String, String> tempMap = this.connect.getCases(this.token);

        if (tempMap == null) {
            this.occ.add("No cases connected to the user.");
        } else {
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
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
    }

    /**
     * handles the action showValidationStage()
     */
    private void setValidateAction() {
        this.valiBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 
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
    /**
     * Shows the ValiedateUser.fxml stage
     * @return stage(ValidateUsers.fxml)
     * @throws IOException
     * @throws ApiException 
     */
    private Stage showValidationStage() throws IOException, ApiException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ValidateUsers.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLValidateUsersController controller = loader.<FXMLValidateUsersController>getController();
        controller.initData(this.token);
        stage.setTitle("Logged in as " + token.getName());
        stage.show();
        return stage;
    }

    /**
     * Method to be called when this stage is loaded.
     *
     * @param employee
     */
    public void initData(Token employee) throws ApiException {
        this.token = employee;
         
        this.showsRelevantCases();
        this.caseEditLV.getSelectionModel().select(0);
    }
    /**
     *  method for selecting a case
     * @return selected case
     * @throws ApiException 
     */
    private CriminalCase getSelectedCase() throws ApiException {
        String id;
        String[] ids = caseEditLV.getSelectionModel().getSelectedItem().split("\n");
        id = ids[0];
        return this.connect.getCase(id, this.token);
    }

    /**
     * Displays the selected CriminalCase from the ListView.
     *
     * @param event the editCase button.
     * @return Shows the new Stage
     * @throws IOException
     * @throws ApiException
     */
    @FXML
    private Stage editCase(ActionEvent event) throws IOException, ApiException {

        CriminalCase selectedCase = this.getSelectedCase();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLCaseController caseScreenController = loader.<FXMLCaseController>getController();

         

        if (selectedCase == null) {
            this.caseNotEditedLBL.setVisible(true);
        } else {
            this.token.setTimeStamp(Long.toString(this.date.getTime()));

            stage.setTitle("Logged in as " + token.getName());

            caseScreenController.initData(selectedCase, this.token);

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {

                    if (caseScreenController.hasBeenChanged()) {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CloseCaseConfirmScreen.fxml"));
                            Stage confirmStage = new Stage(StageStyle.DECORATED);

                            confirmStage.setScene(new Scene((Pane) loader.load()));

                            FXMLCloseCaseConfirmScreenController confirmScreenController = loader.<FXMLCloseCaseConfirmScreenController>getController();
                            confirmScreenController.initData(caseScreenController);
                            confirmStage.setTitle("Save changes?");
                            confirmStage.showAndWait();

                            if (!confirmScreenController.shouldCloseCase()) {
                                we.consume();
                            }

                            updateCaseOnClose(caseScreenController);

                        } catch (IOException ex) {
                            Logger.getLogger(FXMLCloseCaseConfirmScreenController.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }
                    if (!caseScreenController.wasBeingEditedBeforeOpen()) {
                        updateCaseOnClose(caseScreenController);
                    }
                    caseScreenController.interuptUpdateThread();
                }
            });

            stage.show();
        }

        return stage;
    }

    /**
     * update case when window is closed
     * @param caseScreenController 
     */
    private void updateCaseOnClose(FXMLCaseController caseScreenController) {
        try {      
            caseScreenController.getCase().setIsBeingUpdated(false);
            caseScreenController.updateCase();
        } catch (ApiException ex) {
            Logger.getLogger(FXMLShowCaseScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Displays the screen where a user can add a new CriminalCase.
     *
     * @param event the addCase button
     * @return Shows the new Stage
     * @throws IOException
     */
    @FXML
    private Stage addCase(ActionEvent event) throws IOException, ApiException {
   
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CaseScreen.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) loader.load()));

            FXMLCaseController controller = loader.<FXMLCaseController>getController();
            controller.initData(null, this.token);
            stage.setTitle("Logged in as " + token.getName());

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    controller.interuptUpdateThread();
                }
            });

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
    /**
     * view profile
     * @param event
     * @return showUserScreenStage
     * @throws IOException
     * @throws ApiException 
     */
    @FXML
    private void viewProfile(ActionEvent event) throws IOException, ApiException {
        showUserScreenStage(this.token);

    }

    /**
     * Displays the view user screen.
     * @param connector not relevant
     * @return stage.
     * @throws IOException
     */
    private Stage showUserScreenStage(Token t) throws IOException, ApiException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewUserProfile.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLViewUserProfileController controller = loader.<FXMLViewUserProfileController>getController();
        controller.initData(null, t);
        stage.setTitle("Logged in as " + token.getName());

        stage.show();
        return stage;
    }

    /**
     *  search button for ShowCasesScreenController
     * @param event 
     */
    @FXML
    private void searchAction(ActionEvent event) {
        String searchInput = this.caseSearchTF.getText();
        this.tempCaseList = FXCollections.observableArrayList();

        for (String s : this.occ) {

            if (s.toLowerCase().contains(searchInput.toLowerCase())) {
                this.tempCaseList.add(s);
            }
        }
        this.caseEditLV.setItems(this.tempCaseList);
    }

    /**
     * selected news mouse event
     * @param event 
     */
    @FXML
    private void handleChosenNewsAction(MouseEvent event) {
        if (this.newsLV.getSelectionModel().getSelectedItem() != null) {
            this.selectedNewsTA.setText(this.newsLV.getSelectionModel().getSelectedItem().getBody());
        }
    }

    @FXML
    private void handleLogoutAction(ActionEvent event) throws IOException {
        this.token.setTimeStamp("0");
        Stage thisStage = (Stage) this.logoutBTN.getScene().getWindow();
        thisStage.close();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        stage.setTitle("Login for Evidence Management System");
        stage.show();
    }

}
