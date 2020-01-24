/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sh.business.BOFactory;
import sh.business.custom.CustomerBO;
import sh.dto.CustomerDTO;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class View2Controller implements Initializable {

    @FXML
    private TableView<CustomerDTO> viewTable;
    
    CustomerBO customerBO;
    @FXML
    private AnchorPane viewAnchor1;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //Initializing Business Objects
                customerBO= (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
       
                
            viewTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
            viewTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
           viewTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Gender"));
            viewTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Address")); 
           viewTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Country"));
            viewTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Nationality"));
            viewTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("idNum"));
            viewTable.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
            
           
            
            
         
            
            ArrayList<CustomerDTO> aa= customerBO.getAll();
            viewTable.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(View2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
