/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.view.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sh.business.BOFactory;
import sh.business.custom.RoomBO;
import sh.business.custom.RoomBookingBO;
import sh.dto.RoomBookingDTO;
import sh.dto.RoomDTO;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane mainAp;
    @FXML
    private Button registerBtn;
    @FXML
    private Button bookingBtn;
    @FXML
    private Button viewBtn;
    @FXML
    private AnchorPane homePanel;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img6;
    @FXML
    private Button customerBtn;
    @FXML
    private ImageView img7;
    @FXML
    private Button roomBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private ImageView imgl;
    @FXML
    private ImageView hameimg;
    @FXML
    private ImageView imgp;
    @FXML
    private Label dateLbl;
    
    RoomBO roomBO;
    RoomBookingBO roombookingBO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOG:\My Netbeans Projects\My Projects\AmarshaHotel\src\
       
           //Initializing Business Objects........
        try {
            roomBO= (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);
            roombookingBO=  (RoomBookingBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOMBOOKING);
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        





        //Date
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd | HH:mm");  
        dateLbl.setText(dateFormat.format(date)); 
           


        //updating roomStatus...
        try {
            ArrayList<RoomBookingDTO> roombookings= roombookingBO.getAll();
            Boolean updated;
            RoomDTO room;
            int x;
            for(RoomBookingDTO roombooking:roombookings){
                 x= date.compareTo(roombooking.getOutDate());
                if(x>0){
                    room= roomBO.search(roombooking.getRoomNo());
                    room.setRoomStatus("Available");
                    updated= roomBO.update(room);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
     
    }    

    @FXML
    private void regBtnclicked(ActionEvent event) {
        
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/CustomerReg.fxml"));
            homePanel.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void bkBtnclicked(ActionEvent event) {
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/Booking1.fxml"));
            homePanel.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewBtnclicked(ActionEvent event) {
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/View1.fxml"));
            homePanel.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void customerBtnclicked(ActionEvent event) {
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/Customer.fxml"));
            homePanel.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void roomBtnclicked(ActionEvent event) {
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/Room.fxml"));
            homePanel.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeBtnclicked(ActionEvent event) {
          
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    
    }
    
}
