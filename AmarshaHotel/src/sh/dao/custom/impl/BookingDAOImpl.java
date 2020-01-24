/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import sh.dao.custom.BookingDAO;
import sh.db.DBConnection;
import sh.dto.BookingDTO;

/**
 *
 * @Sahan Amarsha
 */
public class BookingDAOImpl implements BookingDAO{
    
    Connection connection;

    public BookingDAOImpl() throws Exception {
        connection= DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean add(BookingDTO t) throws Exception {
      String SQL = "Insert into Booking values(?,?,?)";
       PreparedStatement stm = connection.prepareStatement(SQL);
       stm.setObject(1, t.getBookingId());
       stm.setObject(2, t.getDate());
       stm.setObject(3, t.getCustomerId());
       return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(BookingDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BookingDTO search(String t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BookingDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
