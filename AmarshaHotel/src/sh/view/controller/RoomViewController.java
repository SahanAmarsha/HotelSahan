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
import sh.business.custom.RoomBO;
import sh.dto.CustomerDTO;
import sh.dto.RoomDTO;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class RoomViewController implements Initializable {

    @FXML
    private AnchorPane viewAnchor;
  
    
    RoomBO roomBO;
    @FXML
    private TableView<RoomDTO> viewTable1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //Initializing business Objects
            roomBO= (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);
            
            viewTable1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
            viewTable1.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("RoomType"));
            viewTable1.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("FloorNo"));
            viewTable1.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("RoomPrice"));
            viewTable1.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("RoomDsc"));
            viewTable1.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("RoomStatus"));
            
            ArrayList<RoomDTO> aa= roomBO.getAll();
            viewTable1.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(RoomViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }    
    
}
