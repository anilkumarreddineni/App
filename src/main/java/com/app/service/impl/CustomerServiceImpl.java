package com.app.service.impl;

import com.app.beans.Customer;
import com.app.dao.CustomerDao;
import com.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return customerDao.deleteCustomer(id);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerDao.getCustomer(id);
    }
}
