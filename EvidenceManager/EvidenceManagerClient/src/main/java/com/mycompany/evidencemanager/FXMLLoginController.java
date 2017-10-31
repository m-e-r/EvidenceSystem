package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLLoginController implements Initializable {
    private LoginTest lgt;
    private IServerConnect connect;
    
    private Label label;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button loginBTN;
    @FXML
    private Label loginLabel;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
    }    
    
    @FXML
    private void handleLoginAction(ActionEvent event) throws ApiException, IOException {
        
        //Format expected by the server when the user leaves the textfields empty;
        String userName = " ";
        String password = " ";
        
        
        //Set the strings if textfields are not empty
        if(!this.userNameTF.getText().trim().isEmpty()){
            userName = this.userNameTF.getText();
        }
        
        if (!this.passwordTF.getText().trim().isEmpty()){
            password = this.passwordTF.getText();
        }
        
        
        //Send the information the the server
//        if (this.connect.doSomeLogin(userName, password) == 0) {
//            this.showCaseScreenStage(this.connect);
//        } else {
//            this.loginLabel.setText("Prøv igen..");
//        }
        
        this.showCaseScreenStage(connect);

    }
    private Stage showCaseScreenStage(IServerConnect connector) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShowCaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLShowCaseScreenController controller = loader.<FXMLShowCaseScreenController>getController();
        
        
        stage.show();
        return stage;
    }
}
