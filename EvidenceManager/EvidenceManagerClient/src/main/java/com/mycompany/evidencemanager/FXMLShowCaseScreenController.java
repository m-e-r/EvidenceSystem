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

    private IServerConnect connect;

    ObservableList<CriminalCase> occ;

    @FXML
    private TextArea evidenceInfoTA;
    @FXML
    private ListView<CriminalCase> caseEditLV;
    @FXML
    private TextField caseSearchTF;
    @FXML
    private TextArea caseDescriptionTA;
    @FXML
    private Button editCaseBTN;
    @FXML
    private Button addCaseBTN;
    @FXML
    private Button removeEvidenceBTN;
    @FXML
    private Button removeCaseBTN;
    @FXML
    private Button addEvidenceBTN;
    @FXML
    private Button malplacedSearchBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.connect = new ServerConnect();

    }

    @FXML
    private void searchCase(ActionEvent event) throws ApiException {
         int caseID = 1;
        CriminalCase cc;
        ObservableList<CriminalCase> occ = FXCollections.observableArrayList();

        //caseID = Integer.parseInt(caseSearchTF.getText());
       
       
      
                System.err.println("Hello");
                cc = connect.getCase(caseID);
                occ.add(cc);
                System.out.println(occ.toString());
                caseEditLV.setItems(occ);
                caseEditLV.toString();
            
        
        
         
        

    }

    public void initData(IServerConnect isc) {
        this.connect = isc;
    }

    @FXML
    private void editCase(ActionEvent event) {
    }

    @FXML
    private Stage addCase(ActionEvent event) throws IOException {
        initData(connect);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLCaseController controller = loader.<FXMLCaseController>getController();
        
        stage.show();
        return stage;

    }

    @FXML
    private void removeEvidence(ActionEvent event) {
    }

    @FXML
    private void removeCase(ActionEvent event) {
    }

    @FXML
    private void addEvidence(ActionEvent event) {
    }

}
