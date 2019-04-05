package com.app.controller;

import com.app.Constants.ResourceLocator;
import com.app.beans.Customer;
import com.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

/*	@Autowired
	private Customer customer;*/

	@Autowired
	private CustomerService customerService;

	/**
	 * To check the health of the server.
	 * @return
	 */
	@RequestMapping("/")
	public String healthCheck() {
		return "Server is up and Running";
	}

	/**
	 * Rest Service to add the Customer.
	 * @param customer
	 * @return
	 */
	@RequestMapping(value= ResourceLocator.ADD, method=RequestMethod.POST, consumes = "application/json")
	public String addCustomer(@RequestBody Customer customer) {
		String message="";
		boolean flag=customerService.addCustomer(customer);
		if(flag){
			message="Customer added Successfully";
		}else{
			message="Customer is not added Successfully";
		}
		return message;
	}

	/**
	 * Rest Service to update the Customer.
	 * @param customer
	 * @return
	 */
	@RequestMapping(value=ResourceLocator.UPDATE, method=RequestMethod.POST, consumes = "application/json")
	public String updateCustomer(@RequestBody Customer customer) {
		String message="";
		boolean flag=customerService.updateCustomer(customer);
		if(flag){
			message="Customer updated Successfully";
		}else{
			message="Customer is not updated Successfully";
		}
		return message;
	}

	/**
	 * Rest Service to delete the Customer.
	 * @param id
	 * @return
	 */
	@RequestMapping(value=ResourceLocator.DELETE)
	public String deleteCustomer(@RequestParam(name="id", required=false, defaultValue="Unknown") Long id) {
		String message="";
		boolean flag=customerService.deleteCustomer(id);
		if(flag){
			message="Customer deleted Successfully";
		}else{
			message="Customer is not Available";
		}
		return message;
	}

	/**
	 * Rest Service to get the customer
	 * @param id
	 * @return
	 */
	@RequestMapping(value=ResourceLocator.GET)
	public Customer getCustomer(@RequestParam(name="id", required=false, defaultValue="Unknown") Long id) {
		Customer customer=customerService.getCustomer(id);
		if(customer==null){
			customer=new Customer();
		}
		return customer;
	}

}
