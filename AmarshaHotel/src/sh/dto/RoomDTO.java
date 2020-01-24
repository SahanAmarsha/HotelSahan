/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dto;

import java.io.Serializable;

/**
 *
 * Sahan Amarsha 
 */
public class RoomDTO extends SuperDTO implements Serializable {
    
    private String no;
    private String type;
    private int floorno;
    private String dsc;
    private String status;
    private double price;
    
    public  RoomDTO(){
        
    }
    
    public  RoomDTO(String RoomNo,String RoomType,int FloorNo,double RoomPrice,String RoomDsc,String RoomStatus){
        this.no= RoomNo;
        this.type= RoomType;
        this.floorno= FloorNo;
        this.price= RoomPrice;
        this.dsc=RoomDsc;
        this.status=RoomStatus;
    }
    
    public String getRoomNo(){
        return this.no;
    
    }
    
    public void setRoomNo(String no){
        this.no=no;
    }
                
   public String getRoomType(){
    return this.type; 
    }
                    
                
  public void setRoomType(String type){
        this.type=type;
    }

   public int getFloorNo(){
    return this.floorno; 
    }
                    
  public void setFloorNo(int no){
        this.floorno=no;
    }

   public double getRoomPrice(){
    return this.price; 
    }
                    
                
  public void setRoomPrice(double price){
        this.price=price;
    }

                
   public String getRoomDsc(){
    return this.dsc; 
    }
                    
  public void setRoomDsc(String dsc){
        this.dsc=dsc; 
    }

                
   public String getRoomStatus(){
    return this.status; 
    }
                    
  public void setRoomStatus(String status){
         this.status=status; 
    }
                
    
}
