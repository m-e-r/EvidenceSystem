package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLLoginController implements Initializable {
    private LoginTest lgt;
    private Client client;
    
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
        this.client = new Client();
    }    
    
    @FXML
    private void handleLoginAction(ActionEvent event) throws ApiException {
        if (this.client.doSomeLogin(this.userNameTF.getText(), this.passwordTF.getText())) {
            this.loginLabel.setText("Godt logget ind!");
        } else {
            this.loginLabel.setText("Prøv igen..");
        }
    }
}
