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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sh.business.BOFactory;
import sh.business.custom.CustomerBO;
import sh.dto.CustomerDTO;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class CustomerController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField idTxt;
    @FXML
    private TextField pnumTxt;
    @FXML
    private TextField addressTxt;
    @FXML
    private JFXComboBox<String> genderCmbBox;
    @FXML
    private JFXComboBox<String> nationalityCmbBox;
    @FXML
    private JFXComboBox<String> countryCmbBx;
    @FXML
    private TextField idnumTxt;
    @FXML
    private TextField nameTxt;
    @FXML
    private Button searchBtn;
    @FXML
    private Text txt;
    @FXML
    private Button removeBtn;

    /**
     * Initializes the controller class.
     */
    
    CustomerBO customerBO;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            customerBO= (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
    //------------------------------------------------------------------------------
    
    
    
    
    }    

    @FXML
    private void updateBtnclicked(ActionEvent event) {

           
        try {
            String cid= idTxt.getText();
            String name= nameTxt.getText();
            String address= addressTxt.getText();
            int phonenum= Integer.parseInt(pnumTxt.getText());
            String gender= (String)genderCmbBox.getValue();
            String nationality= (String)nationalityCmbBox.getValue();
            String country= (String)countryCmbBx.getValue();
            String idnum= idnumTxt.getText();
            CustomerDTO customer = new CustomerDTO(cid, name, address, gender, country, nationality, idnum, phonenum);
            boolean updateCustomer=customerBO.update(customer);
             Alert alert;
            if(updateCustomer){
                alert=new Alert(Alert.AlertType.INFORMATION,"Updated SucessFully");
                alert.show();
                clearText();

            }else {
                alert=new Alert(Alert.AlertType.ERROR,"Updated");
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
    }

    @FXML
    private void removeBtnclicked(ActionEvent event) {
        try {
            boolean deleteCustomer= customerBO.delete(idTxt.getText());
             if(deleteCustomer){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Deleted SuccessFully",ButtonType.OK);
                clearText();
             }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Deleted",ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchBtnclicked(ActionEvent event) throws Exception {
        CustomerDTO customer= customerBO.search(idTxt.getText());
         if(customer !=null){
                idTxt.setText(customer.getId());
                nameTxt.setText(customer.getName());
                addressTxt.setText(customer.getAddress());
                countryCmbBx.setValue(customer.getCountry());
                pnumTxt.setText(customer.getPhoneNo()+"");
                idnumTxt.setText(customer.getidNum());
                genderCmbBox.setValue(customer.getGender());
                nationalityCmbBox.setValue(customer.getNationality());
                }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Customer Searching Failed",ButtonType.OK);
                alert.show();
            }
    }
    



private void clearText(){
    idTxt.setText("");
    nameTxt.setText("");
    addressTxt.setText("");
    idnumTxt.setText("");
    pnumTxt.setText("");

}












}
