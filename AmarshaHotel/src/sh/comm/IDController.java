/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.comm;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import sh.db.DBConnection;


/**
 *
 * @Sahan Amarsha
 */
public class IDController {
    
    public static String getLastID(String tableName,String colName) throws Exception{
    Connection connection;
    connection= (Connection) DBConnection.getInstance().getConnection();   
        String SQL="SELECT "+colName+" FROM "+tableName+" ORDER BY 1 DESC LIMIT 1";
       
        Statement stm =  (Statement) connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return rst.getString(1);
        }
        return  null;
    }
    
    
}
