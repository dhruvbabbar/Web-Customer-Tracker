package com.dhruv.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhruv.mvc.DAO.CustomerDAO;
import com.dhruv.mvc.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject customer DAO
	@Autowired
	private CustomerDAO customerDao;
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}
	@Transactional
	public void saveCustomer(Customer theCustomer)
	{
		customerDao.saveCustomer(theCustomer);		
	}
	@Transactional
	public Customer getCustomer(int id) {
		
		return customerDao.getCustomer(id);
	}
	@Transactional
	public void deleteCustomer(int id)
	{
		 customerDao.deleteCustomer(id);
	}

}
