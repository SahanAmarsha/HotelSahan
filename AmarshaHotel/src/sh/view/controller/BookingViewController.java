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
import sh.business.BOFactory;
import sh.business.custom.RoomBO;
import sh.business.custom.RoomBookingBO;
import sh.dto.BookingDTO;
import sh.dto.RoomBookingDTO;
import sh.dto.RoomDTO;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class BookingViewController implements Initializable {

    @FXML
    private TableView<RoomBookingDTO> viewTable;
    
    RoomBookingBO roombookingBO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //Initializing business Objects
            roombookingBO=  (RoomBookingBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOMBOOKING);
            
            viewTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
            viewTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("BookingId"));
            viewTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("RoomPrice"));
            viewTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("InDate"));
            viewTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("OutDate"));
            viewTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("PeopleCount"));
            
            ArrayList<RoomBookingDTO> aa= roombookingBO.getAll();
            viewTable.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(BookingViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
