/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dao;

import sh.dao.custom.impl.BookingDAOImpl;
import sh.dao.custom.impl.CustomerDAOImpl;
import sh.dao.custom.impl.RoomBookingDAOImpl;
import sh.dao.custom.impl.RoomDAOImpl;

/**
 *
 * @author user
 */
public class DAOFactory {
        public enum DAOType{
        CUSTOMER, ROOM, ROOMBOOKING, BOOKING
    }
     
      private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance(){
        if (daoFactory==null) {
            daoFactory= new DAOFactory();
        }
        return daoFactory;
    }
    
     public SuperDAO getDAO(DAOType dAOType) throws Exception{
        switch(dAOType){
            case CUSTOMER: return new CustomerDAOImpl();
            case ROOM: return new RoomDAOImpl();
            case ROOMBOOKING: return new RoomBookingDAOImpl();
            case BOOKING: return new BookingDAOImpl();
            default: return null;
        }
    }  

}
