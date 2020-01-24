/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dto;

import java.io.Serializable;

/**
 *
 * @Sahan Amarsha
 */
public class CustomerDTO extends SuperDTO implements Serializable{
    private String id;
    private String name;
    private String address;
    private String country;
    private String idnum;
    private int phonenum;
    private String gender;
    private String nationality;
    
        public CustomerDTO() {
    }
    
        public CustomerDTO(String Id, String Name, String Gender, String Address, String Country, String Nationality, String idNum, int PhoneNo ) {
        this.id = Id;
        this.name = Name;
        this.gender= Gender;
        this.country= Country;
        this.nationality= Nationality;
        this.address = Address;
        this.idnum= idNum;
        this.phonenum= PhoneNo;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id= id;
    }
    
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    
    public String getGender(){
        return this.gender;
    } 
    
    public void setGender(String gender){
        this.gender= gender;
    }
    
    public String getCountry(){
        return this.country;
    }
    
    public void setCountry(String country){
        this.country= country;
    }
    
    
    public void setNationality(String nationality){
        this.nationality= nationality;
    }
    
    public String getNationality(){
        return this.nationality;
    }

    public String getAddress(){
        return this.address;
    }
 
    public void setAddress(String address){
        this.address=address;
    }

    
    public String getidNum(){
        return this.idnum;
    }
    
    public void setidNum(String idNum){
        this.idnum=idNum;
    }

     public int getPhoneNo(){
        return this.phonenum;
    }
    
    public void setPhoneNum(int phonenum){
        this.phonenum=phonenum;
    }
    
 
}
