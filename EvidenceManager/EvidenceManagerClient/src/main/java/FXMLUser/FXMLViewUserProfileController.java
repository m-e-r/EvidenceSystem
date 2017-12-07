package FXMLUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import io.swagger.client.ServerConnect;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import io.swagger.client.model.UserType;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

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
    private TextField stationTF;
    @FXML
    private Button editProfilBTN;
    @FXML
    private TextField roleTF;
    @FXML
    private TextField isValidatedTF;    
    
    
    private User user;
    private IUser connect; 
    private ObservableList<String> cbList;
    private List<String> userList;
    private Token token;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        this.userList = new ArrayList<>();
    }

    /**
     * Method that saves an edited profile to the database
     *
     * @param event
     */
    @FXML
    private void saveEditProfle(ActionEvent event) {
        String name = this.nameTF.getText();
        String username = this.usernameTF.getText();
        String adress = this.adressTF.getText();
        String position = this.roleTF.getText();

        User updatedUser = new User();
        updatedUser.setAddress(adress);
        updatedUser.setName(name);
        updatedUser.setUsername(username);
        updatedUser.setRole(position);

    }

    /**
     * Method that initializes the text fields. Is called when screen is set.
     *
     * @param user The user that should be shown.
     */
    public void initData(User user, Token t) {
        this.token = t;
        this.user = user;
        

        this.nameTF.setText(this.user.getName());
        this.idTF.setText(this.user.getEmployeeId());
        this.birthdayTF.setText(this.user.getBirthday());
        this.usernameTF.setText(this.user.getUsername());
        this.passwordTF.setText("********");
        this.adressTF.setText(this.user.getAddress());
        this.roleTF.setText(this.user.getRole());
        this.stationTF.setText(this.user.getLocation());
        
        //Use this try if different fields should be open based on ADMIN login
//        try {
//            switch (UserType.valueOf("police_officer".toUpperCase())) {
//                case SYSTEM_ADMIN:
//                    System.out.println("yeah");
//                    break;
//
//                default:
//                    System.out.println("Oh no");
//            }
//        } catch (IllegalArgumentException ie) {
//            System.out.println("Oh no x2");
//        }
        
        this.idTF.setDisable(true);
        this.birthdayTF.setDisable(true);
        this.usernameTF.setDisable(true);
        this.roleTF.setDisable(true);
        this.isValidatedTF.setDisable(true);

    }

    @FXML
    private void handleClearPassTF(MouseEvent event) {
        if (this.passwordTF.getText().equals("********"))
            this.passwordTF.clear();
    }

    @FXML
    private void handleFillPassTF(MouseEvent event) {
        if (this.passwordTF.getText().trim().isEmpty()) {
            this.passwordTF.setText("********");
        }
    }

}
