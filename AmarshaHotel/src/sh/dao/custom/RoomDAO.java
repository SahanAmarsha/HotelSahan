/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dao.custom;

import sh.dao.SuperDAO;
import sh.dto.CustomerDTO;
import sh.dto.RoomDTO;

/**
 *
 * @author user
 */

    public interface RoomDAO extends SuperDAO<RoomDTO>{
    public int getRoomCount() throws Exception;
}


