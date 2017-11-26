package com.mycompany.evidencemanager;

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.Token;
import io.swagger.client.model.UserType;
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
import security.ClientSecurity;

public class FXMLLoginController implements Initializable {

    //Attributes
    private IServerConnect connect; //For calling methods on the server
    private ISecurity security;

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
        this.security = new ClientSecurity();
    }

    /**
     * Logs a user in based on username/password combination. Displays the next
     * screen based on the login credentials (returned from server).
     *
     * @param event the login button
     * @throws ApiException
     * @throws IOException
     */
    @FXML
    private void handleLoginAction(ActionEvent event) throws ApiException, IOException {
        LoginTestClass lgc = new LoginTestClass();
        //Format expected by the server when the user leaves the textfields empty;
        String userName = " ";
        String password = " ";

        //Set the strings if textfields are not empty
        if (!this.userNameTF.getText().trim().isEmpty()) {
            userName = this.userNameTF.getText();
        }

        if (!this.passwordTF.getText().trim().isEmpty()) {
            password = this.passwordTF.getText();
        }
        
        //Encrypt username and password
        userName = this.security.encrypt(userName);
        password = this.security.encrypt(password);

        //Send the information the the server
        Token token = this.connect.doSomeLogin(userName, password);
        System.out.println(token);
        String hey = "";
        if (token != null) {
            UserType rank = UserType.valueOf(token.getUsertype());
            switch (rank) {
                case COMISSIONER: this.showCaseScreenStage(token);
                break;
                
                case POLICE_OFFICER: this.showCaseScreenStage(token);
                break;
                
                case FORENSIC_SCIENTIST: this.showForensicEvidenceStage(token);
                break;
                
                case SYSTEM_ADMIN: this.loginLabel.setText("Hey Admin");
                break;
                
                default: this.loginLabel.setText("Somthing wrong");
            }
        } else {
            this.loginLabel.setText("Invalid login");
        }
    

//        if (lgc.doLoginUserType(userName, password)==(LoginTestClass.UserType.COMISSIONER)) {
//            this.showCaseScreenStage();
//        } else if(lgc.doLoginUserType(userName, password)==(LoginTestClass.UserType.FORENSIC_SCIENTIST)){
//            this.showForensicEvidenceStage();
//        } else if(lgc.doLoginUserType(userName, password)==(LoginTestClass.UserType.POLICE_OFFICER)){
//            this.showCaseScreenStage();
//        } else if(lgc.doLoginUserType(userName, password)==(LoginTestClass.UserType.SYSTEM_ADMIN)){
//            this.showCaseScreenStage();
//        } else {
//            this.loginLabel.setText("Invalid login");
//        }
    }

    /**
     * Displays the relevant screen to the user.
     *
     * @param connector not relevant
     * @return stage.
     * @throws IOException
     */
    private Stage showCaseScreenStage(Token token) throws IOException, ApiException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShowCaseScreen.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLShowCaseScreenController controller = loader.<FXMLShowCaseScreenController>getController();
        controller.initData(token);
        stage.show();
        return stage;
    }

    
    /** 
     *  Displays the relevant screen to the user(ForensicEvidence)
     * @param token
     * @return stage.
     * @throws IOException 
     */
    private Stage showForensicEvidenceStage(Token token) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ForensicEvidence.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLForensicEvidenceController controller = loader.<FXMLForensicEvidenceController>getController();

        stage.show();
        return stage;
    }
}
