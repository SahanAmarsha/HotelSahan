/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.view.controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import jdk.nashorn.internal.parser.TokenType;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sh.business.BOFactory;
import sh.business.custom.CustomerBO;
import sh.business.custom.RoomBO;
import sh.business.custom.RoomBookingBO;
import sh.comm.IDGenerator;
import sh.db.DBConnection;
import sh.dto.BookingDTO;
import sh.dto.CustomerDTO;
import sh.dto.RoomBookingDTO;
import sh.dto.RoomDTO;

/**
 * FXML Controller class
 *
 * @Sahan Amarsha
 */
public class Booking1Controller implements Initializable {

    @FXML
    private AnchorPane b1Anchor;
    @FXML
    private ImageView img1;
    @FXML
    private TextField idTxt;
    @FXML
    private TextField nameTxt;
    @FXML
    private JFXComboBox<String> roomtypeTxt;

    @FXML
    private TextField checkindTxt;
    @FXML
    private TextField checkoutdTxt;
    @FXML
    private TextField peopleTxt;
    @FXML
    private Button submitBtn;
    @FXML
    private Button searchBtn;

    /**
     * Initializes the controller class.
     */
    //Creating Business Objects
    CustomerBO customerBO;
    RoomBO roomBO;
    RoomBookingBO roombookingBO;

    @FXML
    private TextField bidTxt;
    @FXML
    private JFXComboBox<String> roomnoCmbBx;
    @FXML
    private Button findBtn;
    @FXML
    private Button printBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
//Initializing business objects
            customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
            roomBO = (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);
            roombookingBO = (RoomBookingBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOMBOOKING);

        } catch (Exception ex) {
            Logger.getLogger(Booking1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        bookingID();

//-------------------------------------------------------
//--------------------------Removing combo box items-------------------------
//---------------------------------------------------------------------------
//--------------------------Initializing combo box items-------------------------  
        roomtypeTxt.getItems().removeAll(roomtypeTxt.getItems());
        roomtypeTxt.getItems().addAll("Non AC Double", "Non AC Single", "Non AC Family", "Normal AC Double", "Normal AC Single", "Normal AC Family", "Luxury Double", "Luxury Single", "Luxury Family");
//---------------------------------------------------------------------------          
    }

    @FXML
    private void searchBtnclicked(ActionEvent event) {
        try {
            CustomerDTO customer = customerBO.search(idTxt.getText());
            if (customer != null) {
                idTxt.setText(customer.getId());
                nameTxt.setText(customer.getName());

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Customer Searching Failed", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(Booking1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void submitBtnclicked(ActionEvent event) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            String bid = bidTxt.getText();
            String id = idTxt.getText();
            String type = roomtypeTxt.getValue();
            String no = roomnoCmbBx.getValue();
            Date indate = new SimpleDateFormat("dd/MM/yyyy").parse(checkindTxt.getText());
            Date outdate = new SimpleDateFormat("dd/MM/yyyy").parse(checkoutdTxt.getText());
            int count = Integer.parseInt(peopleTxt.getText());
            Date date = new Date();

            //Room status must be changed
            RoomDTO room;
            room = roomBO.search(no);
            if (room == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please Select a valid Room Number", ButtonType.OK);
            }
            room.setRoomStatus("Taken");

            //Making data transmission object 
            BookingDTO booking = new BookingDTO(bid, date, id);
            RoomBookingDTO roombooking = new RoomBookingDTO(no, bid, room.getRoomPrice(), indate, outdate, count);

            boolean isupdated = roombookingBO.addTrans(booking, roombooking, room);
            if (isupdated) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Booking Succeeded", ButtonType.OK);
                alert.show();
                cleartext();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Booking Failed", ButtonType.OK);
                alert.show();
            }

        } catch (ParseException ex) {
            Logger.getLogger(Booking1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.setAutoCommit(true);
        }

    }

    public void loadroomtypes() throws Exception {

    }

    public void cleartext() {
        idTxt.setText("");
        bidTxt.setText("");
        nameTxt.setText("");
        checkindTxt.setText("");
        checkoutdTxt.setText("");
        peopleTxt.setText("");
        roomnoCmbBx.getItems().removeAll(roomnoCmbBx.getItems());
        roomtypeTxt.getSelectionModel().select("");
    }

    @FXML
    private void findBtnclicked(ActionEvent event) throws Exception {
        roomnoCmbBx.getItems().removeAll(roomnoCmbBx.getItems());
        ArrayList<RoomDTO> rooms = new ArrayList<>();
        rooms = roomBO.getAll();
        String roomtype;
        roomtype = roomtypeTxt.getValue().replaceAll("\\s", "");
            

        for (RoomDTO room : rooms) {
            room.setRoomType(room.getRoomType().replaceAll("\\s", ""));

            if (room.getRoomType().equals(roomtype)) {
                if (room.getRoomStatus().equals("Available")) {
                    roomnoCmbBx.getItems().add(room.getRoomNo());
                }
            }

        }
    }

    @FXML
    private void printBtnclicked(ActionEvent event) throws ParseException, Exception {

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/sh/jasper/Booking.jasper"));
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("roomNo", roomnoCmbBx.getValue());
        hm.put("roomType", (roomBO.search(roomnoCmbBx.getValue()).getRoomType()));
        hm.put("floorNo", (roomBO.search(roomnoCmbBx.getValue()).getFloorNo()));
        hm.put("roomPrice", (roomBO.search(roomnoCmbBx.getValue()).getRoomPrice()));
        hm.put("checkInDate", new SimpleDateFormat("dd/MM/yyyy").parse(checkindTxt.getText()));
        hm.put("checkOutDate", new SimpleDateFormat("dd/MM/yyyy").parse(checkoutdTxt.getText()));
        hm.put("cId", customerBO.search(idTxt.getText()).getId());
        hm.put("cName", customerBO.search(idTxt.getText()).getName());
        hm.put("bookingId", bidTxt.getText());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, new JREmptyDataSource());
        JasperViewer.viewReport(jasperPrint, false);
        b1Anchor.setVisible(true);

    }

    private void bookingID() {

        try {
            String newBookingID = IDGenerator.getNewID("Booking", "BookingId", "B");
            bidTxt.setText(newBookingID);
        } catch (Exception ex) {
            Logger.getLogger(Booking1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * ArrayList<RoomDTO> rooms = null; //roomBO.getAll(); List<String> avrooms
     * = null; avrooms.add("1");
     *
     * for(RoomDTO room: rooms){ if(room.getRoomStatus()=="Available" &&
     * room.getRoomType()==roomtypeTxt.getValue()){
     * avrooms.add(room.getRoomNo()); }
     *
     * }
     * for (int i = 0; i < avrooms.size(); i++) {
     * roomnoCmbBx.getItems().add("");
        }*
     */
}
