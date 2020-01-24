/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sh.dao.custom.RoomBookingDAO;
import sh.db.DBConnection;
import sh.dto.RoomBookingDTO;
import sh.dto.RoomDTO;

/**
 *
 * @Sahan Amarsha
 */
public class RoomBookingDAOImpl implements RoomBookingDAO{
    
     Connection connection;

    public RoomBookingDAOImpl() throws Exception {
        connection= DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean add(RoomBookingDTO t) throws Exception {
       String SQL = "Insert into RoomBooking values(?,?,?,?,?,?)";
       PreparedStatement stm = connection.prepareStatement(SQL);
       stm.setObject(1, t.getRoomNo());
       stm.setObject(2, t.getBookingId());
       stm.setObject(3, t.getRoomPrice());
       stm.setObject(4, t.getInDate());
       stm.setObject(5, t.getOutDate());
       stm.setObject(6, t.getPeopleCount());
       return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(RoomBookingDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomBookingDTO search(String t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RoomBookingDTO> getAll() throws Exception {
        Statement stm = connection.createStatement();
        ArrayList<RoomBookingDTO> roombookingList=new ArrayList<>();
        ResultSet rst = stm.executeQuery("Select * from roombooking");
        while(rst.next()){
            RoomBookingDTO roombooking= new RoomBookingDTO(
                    rst.getString(1), 
                    rst.getString(2), 
                    rst.getDouble(3),
                    rst.getDate(4),
                    rst.getDate(5),
                    rst.getInt(6)
            );
            roombookingList.add(roombooking);
        }
        return roombookingList;
    }
    
}
