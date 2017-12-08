/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

import FXMLUser.FXMLFindUserController;
import FXMLUser.IUser;
import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLAssignPersonelController implements Initializable {

    @FXML
    private TextField searchTF;
    @FXML
    private TableView<User> usersTV;
    @FXML
    private TableColumn<User, String> TVidCol;
    @FXML
    private TableColumn<User, String> TVNameCol;
    @FXML
    private TableColumn<User, String> TVRankCol;
    @FXML
    private Button addBTN;
    @FXML
    private Button removeBTN;
    @FXML
    private Button addAllBTN;
    @FXML
    private Button clearAllBTN;
    @FXML
    private ListView<User> selectedLV;
    
    private Token token;
    private ObservableList<User> userList;
    private IUser connect;
    private Date date;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        this.date = new Date();
    }

    public void initData(Token token) {
        this.token = token;
        this.setUserList();
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {
    }

    @FXML
    private void handleAddAllAction(ActionEvent event) {
    }

    @FXML
    private void handleClearAllAction(ActionEvent event) {
    }
    
    private void setUserList() {
        List<User> users = null;
        try {
            users = connect.getListOfUsers(this.token);
        } catch (ApiException ex) {
            Logger.getLogger(FXMLFindUserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (users != null) {
            TVidCol.setCellValueFactory(new PropertyValueFactory<User, String>("employeeId"));
            TVNameCol.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
            TVRankCol.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
            this.userList = FXCollections.observableArrayList(users);
            usersTV.setItems(this.userList);
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
        }
    }
    
    private void searchMethod() {

        searchTF.textProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(javafx.beans.Observable observable) {
                if (searchTF.textProperty().get().isEmpty()) {
                    usersTV.setItems(userList);
                }

                ObservableList<User> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<User, ?>> cols = usersTV.getColumns();

                for (int i = 0; i < userList.size(); i++) {
                    for (int j = 0; j < cols.size(); j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = (String) col.getCellData(userList.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if (cellValue.contains(searchTF.textProperty().get().toLowerCase())) {
                            tableItems.add((User) userList.get(i));
                            break;
                        }
                    }
                    usersTV.setItems(tableItems);

                }
            }
        });
    }
    
}
