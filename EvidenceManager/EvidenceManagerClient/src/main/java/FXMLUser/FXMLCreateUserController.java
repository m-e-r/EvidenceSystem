package FXMLUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import security.ClientSecurity;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLCreateUserController implements Initializable {
    private IUser connect;
    private ObservableList<UserType> roles;
    private User newUser;
    private ClientSecurity cs;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private ChoiceBox<UserType> roleCB;
    @FXML
    private Button createUserBTN;
    @FXML
    private DatePicker birthdayDP;
    @FXML
    private Label missingLabel;
    @FXML
    private Label userNameTakenLabel;
    
    private Token token;
    @FXML
    private Label successLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        this.newUser = new User();
        this.cs= new ClientSecurity();
        
        this.successLabel.setVisible(false);
        this.missingLabel.setVisible(false);
        this.userNameTakenLabel.setVisible(false);
        
        this.roles = FXCollections.observableArrayList(UserType.values());
        this.roleCB.setItems(this.roles);
        this.roleCB.setValue(UserType.POLICE_OFFICER);
    }    
    
    /**
     * Creates a user from using the text from inputs.
     * @param event
     * @throws ApiException 
     */
    @FXML
    private void handleCreateUserAction(ActionEvent event) throws ApiException {
        
        
        if (this.fieldsAreNotNull()) {
            this.missingLabel.setVisible(false);
            
            this.newUser.setAddress(this.addressTF.getText());
            this.newUser.setBirthday(this.birthdayDP.getValue().toString());
            this.newUser.setName(this.nameTF.getText());
            this.newUser.setPassword(cs.encrypt(this.passwordTF.getText()));
            this.newUser.setUsername(cs.encrypt(this.userNameTF.getText()));
            this.newUser.setRole(this.roleCB.getValue().toString());
            this.newUser.setToken(token);
            if (!this.connect.createNewUser(this.newUser)) {
                this.userNameTakenLabel.setVisible(true);
            } else {
                this.userNameTakenLabel.setVisible(false);
                this.successLabel.setVisible(true);
                Stage stageToClose = (Stage) this.createUserBTN.getScene().getWindow();
                //stageToClose.close();
            }
            
            
        } else {
            this.missingLabel.setVisible(true);
            this.successLabel.setVisible(false);
        }
        
    }

    
    public void initData(Token token){
        this.token = token;
    }
    
    private boolean fieldsAreNotNull() {
        if (this.nameTF.getText().trim().isEmpty())
            return false;
        
        if (this.userNameTF.getText().trim().isEmpty())
            return false;
        
        if (this.passwordTF.getText().trim().isEmpty())
            return false;
        
        if (this.addressTF.getText().trim().isEmpty())
            return false;
        
        if (this.birthdayDP.getValue() == null) //Ikke godt nok
            return false;
        
        return true;
    }


    
}
