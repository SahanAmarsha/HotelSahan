/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.business;

import sh.business.custom.impl.CustomerBOImpl;
import sh.business.custom.impl.RoomBOImpl;
import sh.business.custom.impl.RoomBookingBOImpl;

/**
 *
 * @author user
 */
public class BOFactory {
    
    public enum BOTypes{
        CUSTOMER, ROOM, BOOKING, ROOMBOOKING;
    }
   
    private static BOFactory bOFactory;

    public BOFactory() {
    }
    
    public static BOFactory getInstance(){
        if (bOFactory==null) {
            bOFactory= new BOFactory();
        }
        return bOFactory;
    }
    
        public SuperBO getBO(BOTypes bOTypes) throws Exception{
        switch(bOTypes){
            case CUSTOMER: return new CustomerBOImpl();
            case ROOM: return new RoomBOImpl();
            //case BOOKING: return new BookingBOImpl();
            case ROOMBOOKING: return new RoomBookingBOImpl(); 
            

            default:return  null;
        }
    }
}
