/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dao;

import java.util.ArrayList;
import sh.dto.SuperDTO;

/**
 *
 * @author user
 */
public interface SuperDAO<T extends SuperDTO>{
    
    public boolean add(T t) throws Exception;
    
    public boolean update(T t)throws Exception;
    
    public boolean delete(String t)throws Exception;
    
    public T search(String t)throws Exception;
    
    public ArrayList<T> getAll()throws Exception;
}
