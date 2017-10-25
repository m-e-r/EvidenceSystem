package com.mycompany.evidencemanager;

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
    
    private Label label;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button loginBTN;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleLoginAction(ActionEvent event) {
        this.lgt = new LoginTest(this.userNameTF.getText(), this.passwordTF.getText());
        System.out.println(this.lgt.toString());
    }
}
