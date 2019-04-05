package com.app.service;

import com.app.beans.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface CustomerService {

    public boolean addCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(Long id);

    public Customer getCustomer(Long id);
}
