package com.app.dao.impl;

import com.app.beans.Customer;
import com.app.dao.CustomerDao;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerDaoImpl implements CustomerDao {

    /**
     * Map which is being used a data base until the data base is implemented.
     */
    Map<Long,Customer> map=new HashMap<Long,Customer>();

    @Override
    public boolean addCustomer(Customer customer) {
        map.put(customer.getId(),customer);
        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean flag=false;
        if (map.containsKey(customer.getId())) {
            map.put(customer.getId(),customer);
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        boolean flag=false;
        if (map.containsKey(id)) {
            map.remove(id);
            flag=true;
        }
        return flag;
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer=new Customer();
        if (map.containsKey(id)) {
            customer=map.get(id);
        }
        return customer;
    }
}
