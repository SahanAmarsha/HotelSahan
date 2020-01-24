/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.view.controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class RoomController implements Initializable {

    @FXML
    private AnchorPane roomPanel;
    @FXML
    private TextField roomnoTxt;
    @FXML
    private TextField floornoTxt;
    @FXML
    private TextField priceTxt;
    @FXML
    private TextArea dscTxt;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button addBtn;
    @FXML
    private JFXComboBox<String> roomtypeCmbBx;
    @FXML
    private JFXComboBox<String> statusCmbBx;
    @FXML
    private Button searchBtn;

    /**
     * Initializes the controller class.
     */

            
    RoomBO roomBO;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            roomBO= (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);
        } catch (Exception ex) {
            Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

//initializing combo boxes
     roomtypeCmbBx.getItems().removeAll(roomtypeCmbBx.getItems());
     roomtypeCmbBx.getItems().addAll("Non AC Double","Non AC Single","Non AC Family","Normal AC Double","Normal AC Single", "Normal AC Family","Luxury Double","Luxury Single","Luxury Family");
    
     statusCmbBx.getItems().removeAll(statusCmbBx.getItems());
     statusCmbBx.getItems().addAll("Repair","Available","Taken");
    }
    
    @FXML
    private void updateBtnclicked(ActionEvent event) {
        try {
            boolean isAdded =false;
            String no = roomnoTxt.getText();
            String type = roomtypeCmbBx.getValue();
            int floorno= Integer.parseInt(floornoTxt.getText());
            double price= Double.parseDouble(priceTxt.getText());
            String dsc= dscTxt.getText();
            String status= statusCmbBx.getValue();
            
            
            RoomDTO room= new RoomDTO( no, type, floorno, price, dsc, status);
            isAdded=roomBO.update(room);
            
            
            if(isAdded){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                alert.show();
                clearText();
            } else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Added Fail",ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @FXML
    private void addBtnclicked(ActionEvent event) {
        try {
            boolean isAdded =false;
            String no = roomnoTxt.getText();
            String type = roomtypeCmbBx.getValue();
            int floorno= Integer.parseInt(floornoTxt.getText());
            double price= Double.parseDouble(priceTxt.getText());
            String dsc= dscTxt.getText();
            String status= statusCmbBx.getValue();
            
            
            RoomDTO room= new RoomDTO( no, type, floorno, price, dsc, status);
            isAdded=roomBO.add(room);
            
            
            if(isAdded){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                alert.show();
                clearText();
            } else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Added Fail",ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
    
    
    
    }
    
    
    private void clearText(){
        roomnoTxt.setText("");
        floornoTxt.setText("");
        priceTxt.setText("");
        dscTxt.setText("");  
    }

    @FXML
    private void searchBtnclicked(ActionEvent event) {
        try {
            RoomDTO room=  roomBO.search(roomnoTxt.getText());
            if(room!=null){
                roomnoTxt.setText(room.getRoomNo());
                roomtypeCmbBx.getSelectionModel().select(room.getRoomType());
                floornoTxt.setText(room.getFloorNo()+"");
                priceTxt.setText(room.getRoomPrice()+"");
                dscTxt.setText(room.getRoomDsc());
                statusCmbBx.getSelectionModel().select(room.getRoomStatus());
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Room Searching Failed",ButtonType.OK);
                alert.show();
            }
            
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void deleteBtnclicked(ActionEvent event) {
        try {
            boolean delRoom= roomBO.delete(roomnoTxt.getText());
            if(delRoom){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Deleted SuccessFully",ButtonType.OK);
                clearText();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Deleted",ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
