/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.CriminalCase;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private IServerConnect connect; //Used for calling methods on the server
    private ObservableList<String> occ; //Used for holding case name and id for displaying in the ListView

    @FXML
    private TextArea evidenceInfoTA;
    @FXML
    private ListView<String> caseEditLV;
    @FXML
    private TextField caseSearchTF;
    @FXML
    private TextArea caseDescriptionTA;
    @FXML
    private Button editCaseBTN;
    @FXML
    private Button addCaseBTN;
    @FXML
    private Button removeCaseBTN;
    @FXML
    private Button malplacedSearchBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.connect = new ServerConnect();
        this.occ = FXCollections.observableArrayList();
        
        try {
            this.showsRelevantCases(2);
        } catch (ApiException ex) {
            System.out.println("Load fejl ...");
        }
    }
    
    /**
     * Loads into the ListView all the case names/ids relevant to the logged in user.
     * Should be called from the initData method, NOT initialize.
     * @param employeeId the user who logs in
     * @throws ApiException 
     */
    private void showsRelevantCases(int employeeId) throws ApiException {
        Map<String, String>tempMap = this.connect.getCases(employeeId);
//        Map<String, String> tempMap = new HashMap();
//        
//        tempMap.put("14323", "Malte is the killer");
//        tempMap.put("432454", "Malte is the real killer");
//        tempMap.put("343242", "Malte did it");
        for (String s : tempMap.keySet()) {
            String adder = s + "\n" + tempMap.get(s);
            this.occ.add(adder);
        }

        this.caseEditLV.setItems(this.occ);
    }
    
    /**
     * Method to be called when this stage is loaded.
     * @param isc not relevant
     */
    public void initData(IServerConnect isc) {
        this.connect = isc;

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
        
        cc = this.connect.getCase(2);
        System.err.println(cc.toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLCaseController controller = loader.<FXMLCaseController>getController();
        controller.initData(cc);
        
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
        initData(connect);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLCaseController controller = loader.<FXMLCaseController>getController();
        controller.initData(null);
        
        stage.show();
        return stage;

    }


    @FXML
    private void removeCase(ActionEvent event) {
    }


}
