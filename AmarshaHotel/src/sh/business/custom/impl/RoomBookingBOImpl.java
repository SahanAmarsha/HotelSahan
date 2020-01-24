/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import sh.business.custom.RoomBookingBO;
import sh.dao.DAOFactory;
import sh.dao.custom.BookingDAO;
import sh.dao.custom.RoomBookingDAO;
import sh.dao.custom.RoomDAO;
import sh.db.DBConnection;
import sh.dto.BookingDTO;
import sh.dto.RoomBookingDTO;
import sh.dto.RoomDTO;

/**
 *
 * @Sahan Amarsha
 */
public class RoomBookingBOImpl implements RoomBookingBO {
    
    RoomDAO roomDAO;
    RoomBookingDAO roombookingDAO;
    BookingDAO bookingDAO;
    
     public RoomBookingBOImpl() throws Exception {
      roomDAO=(RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOM);
      bookingDAO=(BookingDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.BOOKING);
      roombookingDAO=(RoomBookingDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOMBOOKING);
    }

    @Override
    public boolean addTrans(BookingDTO bookingDTO, RoomBookingDTO roombookingDTO, RoomDTO roomDTO) throws Exception {
         Connection connection= DBConnection.getInstance().getConnection();
        try {   
        Boolean result=false;
        connection.setAutoCommit(false);
        result = bookingDAO.add(bookingDTO);
        Boolean result1=false;
        if(result){
             result1= roombookingDAO.add(roombookingDTO);
             Boolean result2;
            if(result1){
                 result2= roomDAO.update(roomDTO);
                return result2;
            } else{
                return false;
            }
        } else{
        
            return false;
        }
            
        } catch (Exception e) {
             return false;
        }
    }


    @Override
    public boolean add(RoomBookingDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return roombookingDAO.getAll();
    }

   
}
