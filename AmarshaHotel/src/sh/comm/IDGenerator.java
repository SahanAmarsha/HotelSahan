/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.comm;

import java.text.NumberFormat;

/**
 *
 * @Sahan Amarsha
 */
public class IDGenerator {
    
     public static String getNewID(String tableName,String colName,String prifix) throws Exception{
        String lastID= IDController.getLastID(tableName, colName);
        if (lastID!= null) {
            int id = Integer.parseInt(lastID.split(prifix)[1]);
            id++;
            NumberFormat nf= NumberFormat.getIntegerInstance();
            nf.setMaximumIntegerDigits(3);
            nf.setGroupingUsed(false);
            String newID= nf.format(id);
            
            
            return prifix + newID;
        } else {
            return prifix +"001";
        }
    }
    
}
