package com.app.dao;

import com.app.beans.Customer;

public interface CustomerDao {

    public boolean addCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(Long id);

    public Customer getCustomer(Long id);
}
