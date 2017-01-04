package com.dhruv.mvc.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhruv.mvc.entity.Customer;
@Repository

public class CustomerDAOimpl implements CustomerDAO {
//inject session factory
	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<Customer> getCustomers() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery= currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		List<Customer> customers= theQuery.getResultList();		
		
		return customers;		
	}

	public void saveCustomer(Customer theCustomer)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);		
	}

	public Customer getCustomer(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer= currentSession.get(Customer.class,id);
		return theCustomer;
	}

	public void deleteCustomer(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", id);
		
		int result= theQuery.executeUpdate();
		
		System.out.println("rows affected "+result);
	}

}
