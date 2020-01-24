/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.business.custom;


import sh.business.SuperBO;
import sh.dto.BookingDTO;
import sh.dto.RoomBookingDTO;
import sh.dto.RoomDTO;

/**
 *
 * Sahan Amarsha
 */
public interface RoomBookingBO extends SuperBO<RoomBookingDTO> {
    public boolean addTrans(BookingDTO bookingDTO,RoomBookingDTO roombookingDTO,RoomDTO roomDTO) throws Exception;
    
}
