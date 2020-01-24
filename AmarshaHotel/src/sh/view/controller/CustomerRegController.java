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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sh.business.BOFactory;
import sh.business.custom.CustomerBO;
import sh.comm.IDGenerator;
import sh.dto.CustomerDTO;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class CustomerRegController implements Initializable {

    @FXML
    private Text txt;
    @FXML
    private Button addBtn;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField pnumTxt;
    @FXML
    private TextField idnumTxt;
    @FXML
    private JFXComboBox<String> genderCmbBox;
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private JFXComboBox<String> nationalityCmbBox;
    @FXML
    private JFXComboBox<String> countryCmbBx;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField idTxt;

    /**
     * Initializes the controller class.
     */
    
       CustomerBO customerBO;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            customerBO= (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        } catch (Exception ex) {
            Logger.getLogger(CustomerRegController.class.getName()).log(Level.SEVERE, null, ex);
        }










//Initializing Combo Boxes
        genderCmbBox.getItems().removeAll(genderCmbBox.getItems());
        genderCmbBox.getItems().addAll("Male", "Female");
        genderCmbBox.getSelectionModel().select("Male");
        
        
        nationalityCmbBox.getItems().removeAll(nationalityCmbBox.getItems());
        nationalityCmbBox.getItems().addAll("Sinhalese", "Tamil");
        nationalityCmbBox.getSelectionModel().select("Sinhalese");
        
        
        countryCmbBx.getItems().removeAll(countryCmbBx.getItems());
        countryCmbBx.getItems().addAll("Sri Lanka", "India");
        countryCmbBx.getSelectionModel().select("Sri Lanka");
                
        customerID();
        
    }    



    @FXML
    private void addBtnclicked(ActionEvent event) {
        try {
            boolean isAdded =false;
            String cid= idTxt.getText();
            String name= nameTxt.getText();
            String address= addressTxt.getText();
            int phonenum= Integer.parseInt(pnumTxt.getText());
            String gender= (String)genderCmbBox.getValue();
            String nationality= (String)nationalityCmbBox.getValue();
            String country= (String)countryCmbBx.getValue();
            String idnum= idnumTxt.getText();
            CustomerDTO customer = new CustomerDTO(cid, name, gender, address,  country, nationality, idnum, phonenum);
            isAdded=customerBO.add(customer);
            
            
            if(isAdded){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                alert.show();
                clearText();
            } else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Added Fail",ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerRegController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    private void clearText(){
    idTxt.setText("");
    nameTxt.setText("");
    addressTxt.setText("");
    idnumTxt.setText("");
    pnumTxt.setText("");

}
    
    
    private void customerID(){
        try {
            String newCustID=IDGenerator.getNewID("customer","C_Id","C");
            idTxt.setText(newCustID);
        } catch (Exception ex) {
            Logger.getLogger(CustomerRegController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
