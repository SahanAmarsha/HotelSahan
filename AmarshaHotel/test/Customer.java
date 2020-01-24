/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Customer {
    
    private String name;
    private String address;
    private int idno;

    public Customer() {
    }

    
    public Customer(String name, String address, int idno) {
        this.name = name;
        this.address = address;
        this.idno = idno;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the idno
     */
    public int getIdno() {
        return idno;
    }

    /**
     * @param idno the idno to set
     */
    public void setIdno(int idno) {
        this.idno = idno;
    }
    
   
    
}
