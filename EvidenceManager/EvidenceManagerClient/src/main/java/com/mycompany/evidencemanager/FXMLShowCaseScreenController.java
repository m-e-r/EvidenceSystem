/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.evidencemanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

    @FXML
    private TextArea evidenceInfoTA;
    @FXML
    private ListView<?> caseEditLV;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void searchCase(ActionEvent event) {
    }

    @FXML
    private void editCase(ActionEvent event) {
    }

    @FXML
    private Stage addCase(ActionEvent event) throws IOException {
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
