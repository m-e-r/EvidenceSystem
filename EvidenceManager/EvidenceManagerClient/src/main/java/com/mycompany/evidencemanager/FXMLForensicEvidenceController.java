package com.mycompany.evidencemanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import io.swagger.client.model.Evidence;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Guest Account
 */
public class FXMLForensicEvidenceController implements Initializable {

    private ObservableList<String> eol;
    @FXML
    private ListView<String> evidenceLV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.eol = FXCollections.observableArrayList();
        showEvidenceAlone();
    }

    public void showEvidenceAlone() {
        List<Evidence> eList = new ArrayList<>();
        Evidence e1 = new Evidence();
        e1.setEvidenceDescription("Herro m8");
        e1.setEvidenceNumber(1);
        e1.setLocation("Somewhere");
       
        
        Evidence e2 = new Evidence();
        e1.setEvidenceDescription("Herro m9");
        e1.setEvidenceNumber(2);
        e1.setLocation("Somewhere else");
       
        eList.add(e1);
        eList.add(e2);
        
        
        for (Evidence e : eList) {
            String adder;
            adder = e.toString();
            this.eol.add(adder);
        }
        
        
        this.evidenceLV.setItems(eol);
    }

}
