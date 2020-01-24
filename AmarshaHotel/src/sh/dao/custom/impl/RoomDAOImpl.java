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
import sh.dao.custom.RoomDAO;
import sh.db.DBConnection;
import sh.dto.RoomDTO;

/**
 *
 * @Sahan Amarsha
 */
public class RoomDAOImpl implements RoomDAO{
            Connection connection;

    public RoomDAOImpl() throws Exception {
        connection= DBConnection.getInstance().getConnection();
    }

    @Override
    public int getRoomCount() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(RoomDTO t) throws Exception {
             String SQL="INSERT INTO Rooms VALUE(?,?,?,?,?,?)";
        PreparedStatement ps= connection.prepareStatement(SQL);
        ps.setString(1, t.getRoomNo());
        ps.setString(2, t.getRoomType());
        ps.setInt(3, t.getFloorNo());
        ps.setDouble(4, t.getRoomPrice());
        ps.setString(5, t.getRoomDsc());
        ps.setString(6, t.getRoomStatus());
        
        
        int result = ps.executeUpdate();
        return (result>0);
    }

    @Override
    public boolean update(RoomDTO t) throws Exception {
       String SQL="Update Rooms set Room_Type=?, Floor_Num=?, RoomPrice=?, RoomDsc=?, Status=? where Room_No=? ";
       PreparedStatement stm = connection.prepareStatement(SQL);
       stm.setObject(1,t.getRoomType() );
       stm.setObject(2,t.getFloorNo() );
       stm.setObject(3,t.getRoomPrice() );
       stm.setObject(4,t.getRoomDsc() );
       stm.setObject(5,t.getRoomStatus() );
       stm.setObject(6,t.getRoomNo() );
       return stm.executeUpdate() > 0;

    }

    @Override
    public boolean delete(String t) throws Exception {
         Statement stm = connection.createStatement();
                String SQL = "Delete From Rooms where Room_No='" + t + "'";
                return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public RoomDTO search(String t) throws Exception {
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * From Rooms where Room_No='"+t+"'");
        if(rst.next()){
            return new RoomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4),
                    rst.getString(5),
                    rst.getString(6)
            
            );
            
        } else{
            return null;
        }
    
    }

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception {
        Statement stm = connection.createStatement();
        ArrayList<RoomDTO> roomList=new ArrayList<>();
        ResultSet rst = stm.executeQuery("Select * from Rooms");
        while(rst.next()){
            RoomDTO room = new RoomDTO(
                    rst.getString(1), 
                    rst.getString(2), 
                    rst.getInt(3),
                    rst.getDouble(4),
                    rst.getString(5),
                    rst.getString(6)
            );
            roomList.add(room);
        }
        return roomList;
    }
    
}
