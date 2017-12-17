/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLUser;

import FXMLEntity.FXMLCaseController;
import FXMLUser.FXMLFindUserController;
import FXMLUser.IUser;
import io.swagger.client.ApiException;
import io.swagger.client.ServerConnect;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.stage.Stage;

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
    private Button saveBTN;
    @FXML
    private ListView<User> selectedLV;

    private Token token;
    private ObservableList<User> availableUsers, selectedUsers;
    private List<User> incomingUsers;
    private IUser connect;
    private Date date;
    private FXMLCaseController caseController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.connect = new ServerConnect();
        this.date = new Date();
        this.selectedUsers = FXCollections.observableArrayList();
        this.availableUsers = FXCollections.observableArrayList();
        this.searchMethod();
    }

    /**
     * constructor for caseController
     * @param caseController
     * @param token 
     */
    public void initData(FXMLCaseController caseController, Token token) {
        this.caseController = caseController;
        this.token = token;
        this.setUserList();
    }

    /**
     * sets the user list based on token
     */
    private void setUserList() {
        try {
            this.incomingUsers = connect.getListOfUsers(this.token);
        } catch (ApiException ex) {
            Logger.getLogger(FXMLFindUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
         

        if (this.incomingUsers != null) {
            this.movePeopleBetweenOptions();

            TVidCol.setCellValueFactory(new PropertyValueFactory<User, String>("employeeId"));
            TVNameCol.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
            TVRankCol.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
            //this.availableUsers = FXCollections.observableArrayList(this.incomingUsers);
            usersTV.setItems(this.availableUsers);
            this.token.setTimeStamp(Long.toString(this.date.getTime()));
        }
    }

    private void movePeopleBetweenOptions() {
        //Remove the person who is logged and in the not validated users from the options
        int s = this.incomingUsers.size();
        for (int i = 0; i < s; i++) {
            String id = this.incomingUsers.get(i).getEmployeeId();
            if (!id.equals(this.token.getId()) && !id.startsWith("NOTValidated") && !id.startsWith("SYSTEM_ADMIN") && !id.startsWith("FORENSIC_SCIENTIST")) {
                this.availableUsers.add(this.incomingUsers.get(i));
            }
        }

        //Move people already associated with the case to the listView
        if (this.caseController.getCase().getAssociates() != null) {
            for (int i = 0; i < this.caseController.getCase().getAssociates().size(); i++) {
                for (int j = 0; j < this.incomingUsers.size(); j++) {
                    if (this.caseController.getCase().getAssociates().get(i).getEmployeeId().equals(this.incomingUsers.get(j).getEmployeeId())) {
                        this.selectedUsers.add(this.incomingUsers.get(j));
                        this.availableUsers.remove(this.incomingUsers.get(j));
                    }
                    
                }
            }

            this.selectedLV.setItems(this.selectedUsers);
        }
    }

    private void searchMethod() {

        searchTF.textProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(javafx.beans.Observable observable) {
                if (searchTF.textProperty().get().isEmpty()) {
                    usersTV.setItems(availableUsers);
                }

                ObservableList<User> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<User, ?>> cols = usersTV.getColumns();

                for (int i = 0; i < availableUsers.size(); i++) {
                    for (int j = 0; j < cols.size(); j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = (String) col.getCellData(availableUsers.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if (cellValue.contains(searchTF.textProperty().get().toLowerCase())) {
                            tableItems.add((User) availableUsers.get(i));
                            break;
                        }
                    }
                    usersTV.setItems(tableItems);

                }
            }
        });
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        User selectedUser = this.usersTV.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            //Add to listView
            this.selectedUsers.add(selectedUser);
            this.selectedLV.setItems(this.selectedUsers);

            //Remove from tableView
            for (int i = 0; i < this.availableUsers.size(); i++) {
                if (this.availableUsers.get(i).getEmployeeId().equals(selectedUser.getEmployeeId())) {
                    this.availableUsers.remove(i);
                    this.usersTV.setItems(this.availableUsers);
                }
            }
        }
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {
        User selectedUser = this.selectedLV.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            //Add to tableView
            this.availableUsers.add(selectedUser);
            this.usersTV.setItems(this.availableUsers);

            //Remove from listView
            for (int i = 0; i < this.selectedUsers.size(); i++) {
                if (this.selectedUsers.get(i).getEmployeeId().equals(selectedUser.getEmployeeId())) {
                    this.selectedUsers.remove(i);
                    this.selectedLV.setItems(this.selectedUsers);
                }
            }
        }
    }

    @FXML
    private void handleAddAllAction(ActionEvent event) {
        if (!this.availableUsers.isEmpty()) {
            //Add to listView
            this.selectedUsers.addAll(this.availableUsers);
            this.selectedLV.setItems(this.selectedUsers);

            //Remove from tableView
            this.availableUsers.clear();
            this.usersTV.setItems(this.availableUsers);
        }
    }

    @FXML
    private void handleClearAllAction(ActionEvent event) {
        if (!this.selectedUsers.isEmpty()) {
            //Add to tableView
            this.availableUsers.addAll(this.selectedUsers);
            this.usersTV.setItems(this.availableUsers);

            //Remove from listView
            this.selectedUsers.clear();
            this.selectedLV.setItems(this.selectedUsers);
        }
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        for (User user : this.selectedUsers) {
            this.caseController.getCase().addAssociatesItem(user);
        }

        Stage thisStage = (Stage) this.saveBTN.getScene().getWindow();
        thisStage.close();
    }

}
