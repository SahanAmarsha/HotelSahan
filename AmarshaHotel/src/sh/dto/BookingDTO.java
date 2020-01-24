/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dto;


import java.io.Serializable;
import java.util.*;

/**
 *
 * @Sahan Amarsha
 */
public class BookingDTO extends SuperDTO  implements Serializable {
    
    
 private String bid;   
 private Date date;
 private String cid;
    
    public BookingDTO(){
        
    }
    
    public BookingDTO(String bid,Date date, String cid){
        this.bid=bid;
        this.cid=cid;
        this.date=date;
    }
    
    public void setBookingId(String bid){
        this.bid=bid;
    }
    
    public String getBookingId(){
        return this.bid;
    }
                
    public void setDate(Date date){
        this.date=date;
    }
    
    public Date getDate(){
        return this.date;
    }

    public void setCustomerId(String cid){
        this.cid=cid;
    }
    
    public String getCustomerId(){
        return this.cid;
    }

    
}
