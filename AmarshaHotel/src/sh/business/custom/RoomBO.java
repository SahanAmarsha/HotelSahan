/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.business.custom;

import sh.business.SuperBO;
import sh.dto.RoomDTO;

/**
 *
 * @Sahan Amarsha
 */
public interface RoomBO extends SuperBO<RoomDTO>{
    public int getRoomCount() throws Exception;
}

