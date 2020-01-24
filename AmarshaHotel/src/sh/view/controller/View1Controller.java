/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class View1Controller implements Initializable {

    @FXML
    private AnchorPane view1AnchorP;
    @FXML
    private Button customerBtn;
    @FXML
    private Button roomBtn;
    @FXML
    private Button bookingBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void customerBtnclicked(ActionEvent event) {
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/View2.fxml"));
            view1AnchorP.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(View1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void roomBtnclicked(ActionEvent event) {
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/RoomView.fxml"));
            view1AnchorP.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(View1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void bookingBtnclicked(ActionEvent event) {
        try {
            AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/sh/view/BookingView.fxml"));
            view1AnchorP.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(View1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
