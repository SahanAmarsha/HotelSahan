/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.db;


import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

/**
 *
 * @Sahan Amarsha
 */
public class DBConnection {
  

    private Connection connection;
      private static DBConnection dBConnection;
    
     private DBConnection() throws ClassNotFoundException, Exception{
        Class.forName("com.mysql.jdbc.Driver");
        File file = new File("resources/application.properties");
        FileReader fileReader = new FileReader(file);
        Properties properties = new Properties();
        properties.load(fileReader);
        String ip = properties.getProperty("ip");
        String port = properties.getProperty("port");
        String db = properties.getProperty("db");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String jdbcUrl ="jdbc:mysql://"+ip+":"+port+"/"+db;
        connection = (Connection) DriverManager.getConnection(jdbcUrl,user,password);
    }
     
      public  static  DBConnection getInstance() throws Exception{
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
    
       public Connection getConnection(){
        return connection;
    }
      
      
}
