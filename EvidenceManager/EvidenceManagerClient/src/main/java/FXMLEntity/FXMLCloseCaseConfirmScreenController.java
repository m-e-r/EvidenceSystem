/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

import io.swagger.client.ApiException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jacob
 */
public class FXMLCloseCaseConfirmScreenController implements Initializable {

    @FXML
    private Button noSaveBTN;
    @FXML
    private Button cancelBTN;
    @FXML
    private Button saveBTN;

    private FXMLCaseController controller;
    
    private boolean close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public boolean shouldCloseCase() {
        return this.close;
    }

    @FXML
    private void dontSaveAction(ActionEvent event) {
        this.close = true;
        this.closeStage(this.noSaveBTN);
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        this.close = false;
        this.closeStage(cancelBTN);

    }

    @FXML
    private void saveChangesAction(ActionEvent event) throws ApiException {
        this.close = true;
        this.controller.updateCase();
        this.closeStage(saveBTN);
    }

    private void closeStage(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    public void initData(FXMLCaseController c) {
        this.controller = c;

    }
}
