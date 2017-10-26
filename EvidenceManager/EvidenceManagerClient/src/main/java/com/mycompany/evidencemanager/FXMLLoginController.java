package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
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
    private ServerConnect client;
    
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
        this.client = new ServerConnect();
    }    
    
    @FXML
    private void handleLoginAction(ActionEvent event) throws ApiException {
        
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
        if (this.client.doSomeLogin(userName, password)) {
            this.loginLabel.setText("Godt logget ind!");
        } else {
            this.loginLabel.setText("Prøv igen..");
        }
    }
}
