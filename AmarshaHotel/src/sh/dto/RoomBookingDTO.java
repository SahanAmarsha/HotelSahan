/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @Sahan Amarsha
 */
public class RoomBookingDTO extends SuperDTO  implements Serializable {
    private String roomno;
    private String id;
    private double price;
    private Date indate;           
    private Date outdate;       
    private int count;
        
    public RoomBookingDTO(){
        
    }
    
    
    public RoomBookingDTO(String RoomNo, String BookingId, double RoomPrice, Date InDate, Date OutDate, int PeopleCount){

        this.roomno= RoomNo;
        this.id=BookingId;
        this.price=RoomPrice;
        this.indate=InDate;
        this.outdate=OutDate;
        this.count=PeopleCount;

    }
            
    public void setRoomNo(String roomno ){
        this.roomno=roomno;
    }        
            
    public String getRoomNo(){
        return this.roomno;
    }       
            
    public void setBookingId(String id){
        this.id=id;
    }        
            
    public String getBookingId(){
        return this.id;
    }            
            
    public void setRoomPrice(double price ){
        this.price=price;
    }        
            
    public double getRoomPrice(){
        return this.price;
    }            
           
                
    public void setInDate(Date indate ){
        this.indate=indate;
    }        
            
    public Date getInDate(){
        return this.indate;
    }                
                
    public void setOutDate(Date outdate ){
        this.outdate=outdate;
    }        
            
    public int getPeopleCount(){
        return this.count;
    }                
                
    public void setPeopleCount(int count ){
        this.count=count;
    }        
            
    public Date getOutDate(){
        return this.outdate;
    }                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                }
