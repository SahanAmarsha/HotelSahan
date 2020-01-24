/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.dao.custom;

import sh.dao.SuperDAO;
import sh.dto.CustomerDTO;

/**
 *
 * @author user
 */
public interface CustomerDAO extends SuperDAO<CustomerDTO>{
    public int getCustomerCount() throws Exception;
}
