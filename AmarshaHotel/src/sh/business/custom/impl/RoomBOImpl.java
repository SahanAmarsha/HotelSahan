/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.business.custom.impl;

import java.util.ArrayList;
import sh.business.custom.RoomBO;
import sh.dao.DAOFactory;
import sh.dao.custom.RoomDAO;
import sh.dto.RoomDTO;

/**
 *
 * @Sahan Amarsha
 */
public class RoomBOImpl implements RoomBO {
    
       RoomDAO roomDAO;

    public RoomBOImpl() throws Exception {
      
        roomDAO= (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOM);
    }

    @Override
    public int getRoomCount() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(RoomDTO t) throws Exception {
       return roomDAO.add(t);
    }

    @Override
    public boolean update(RoomDTO t) throws Exception {
        return roomDAO.update(t);
    }

    @Override
    public boolean delete(String t) throws Exception {
     return roomDAO.delete(t);
    }

    @Override
    public RoomDTO search(String t) throws Exception {
        return roomDAO.search(t);
    }

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception {
      return roomDAO.getAll();
    }
    
    
}
