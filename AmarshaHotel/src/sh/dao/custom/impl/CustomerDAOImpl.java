/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sh.dao.custom.CustomerDAO;
import sh.db.DBConnection;
import sh.dto.CustomerDTO;
import sh.dto.RoomDTO;

/**
 *
 * @Sahan Amarsha
 */
public class CustomerDAOImpl implements CustomerDAO {

        Connection connection;

    public CustomerDAOImpl() throws Exception {
        connection= DBConnection.getInstance().getConnection();
    }
    
    @Override
    public int getCustomerCount() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(CustomerDTO t) throws Exception {
        String SQL="INSERT INTO customer VALUE(?,?,?,?,?,?,?,?)";
        PreparedStatement ps= connection.prepareStatement(SQL);
        ps.setString(1, t.getId());
        ps.setString(2, t.getName());
        ps.setString(3, t.getCountry());
        ps.setString(4, t.getAddress());
        ps.setString(5, ""+t.getPhoneNo());
        ps.setString(6, t.getidNum());
        ps.setString(7, t.getGender());
        ps.setString(8, t.getNationality());
        
        int result = ps.executeUpdate();
        return (result>0);
    }

    @Override
    public boolean update(CustomerDTO customer) throws Exception {
       String SQL = "Update Customer set C_Name=?, Country=?, Address=?, PhoneNumber=?, IDNumber=?, Gender=?, Nationality=? where C_Id=?";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getCountry());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getPhoneNo());
        stm.setObject(5, customer.getidNum());
        stm.setObject(6, customer.getGender());
        stm.setObject(7, customer.getNationality());
        stm.setObject(8, customer.getId());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
                Statement stm = connection.createStatement();
                String SQL = "Delete From Customer where C_Id='" + id + "'";
                return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public CustomerDTO search(String id) throws Exception {
               Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * From Customer where C_Id='"+id+"'");
        if(rst.next()){
            return new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(7),
                    rst.getString(4),
                    rst.getString(3),
                    rst.getString(8),
                    rst.getString(6),
                    rst.getInt(5)
            );
        }else{
            return null;
        }
    }
    

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
               Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * from Customer");
        ArrayList<CustomerDTO> customerList=new ArrayList<>();
        while(rst.next()){
            CustomerDTO customer= new CustomerDTO(
                    rst.getString(1), 
                    rst.getString(2), 
                    rst.getString(7),
                    rst.getString(4),
                    rst.getString(3),
                    rst.getString(8),
                    rst.getString(6),
                    rst.getInt(5)
            );
            customerList.add(customer);
        }
        return customerList;
    }
    
}
