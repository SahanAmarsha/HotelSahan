/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.business.custom.impl;

import java.util.ArrayList;
import sh.business.custom.CustomerBO;
import sh.dao.DAOFactory;
import sh.dao.custom.CustomerDAO;
import sh.dto.CustomerDTO;

/**
 *
 * @Sahan Amarsha
 */
public class CustomerBOImpl implements CustomerBO{
    CustomerDAO customerDAO;

    public CustomerBOImpl() throws Exception {
        customerDAO=(CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);
    }

    @Override
    public int getCustomerCount() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(CustomerDTO superDTO) throws Exception {
          return customerDAO.add(superDTO);
    }

    @Override
    public boolean update(CustomerDTO dto) throws Exception {
         return customerDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return customerDAO.delete(key);
    }

    @Override
    public CustomerDTO search(String key) throws Exception {
         return customerDAO.search(key);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        return customerDAO.getAll();
    }
}
