package FXMLUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.ServerConnect;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author jacob
 */
public class FXMLViewUserProfileController implements Initializable {

    @FXML
    private TextField idTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField birthdayTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField adressTF;
    @FXML
    private ChoiceBox<?> rankCB;
    @FXML
    private TextField stationTF;
    @FXML
    private Button editProfilBTN;
    
    private User user;
    
    private IUser connect;
    @FXML
    private TextField isValidatedTF;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        
    }    

    @FXML
    private void saveEditProfle(ActionEvent event) {
        String name = this.nameTF.getText();
        String username = this.usernameTF.getText();
        String adress = this.adressTF.getText();
        String position = this.rankCB.getSelectionModel().getSelectedItem().toString();
        
        User updatedUser = new User();
        updatedUser.setAddress(adress);
        updatedUser.setName(name);
        updatedUser.setUsername(username);
        updatedUser.setRole(position);
        
       
        
        
        System.out.println("user updated! need to call some api methods!");
    }

    public void initData(User user) {
        this.user = user;
        this.nameTF.setText(this.user.getName());
        this.idTF.setText(this.user.getEmployeeId());
        this.birthdayTF.setText(this.user.getBirthday());
        this.usernameTF.setText(this.user.getUsername());
        this.passwordTF.setText(this.user.getPassword());
        this.adressTF.setText(this.user.getAddress());
        
    }
    
}
