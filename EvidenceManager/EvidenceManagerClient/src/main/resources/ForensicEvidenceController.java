/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.model.Evidence;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Guest Account
 */
public class ForensicEvidenceController implements Initializable {
    private ObservableList<String> eol;
    @FXML
    private ListView<String> evidenceLV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.eol = FXCollections.observableArrayList();
    }    
    
    public void showEvidenceAlone(List<Evidence> eList){
        
        
        
        
        for(Evidence e : eList){
            String adder;
            adder = e.toString();
            this.eol.add(adder);
        }
     this.evidenceLV.setItems(eol);
    }
    
}
