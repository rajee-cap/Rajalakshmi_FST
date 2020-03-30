package org.cap.dao;

import java.util.List;

import org.cap.model.Customer;
import org.springframework.util.MultiValueMap;

public interface ICustomerDao {
	
	public List<Customer> getAllCustomers();

	public List<Customer> createCustomer(Customer customer);

	public List<Customer> deleteCustomer(long id);

	public List<Customer> updateCustomer(Customer customer, long id);

	public List<Customer> updatePatchCustomer(long id, MultiValueMap<Object, Object> formParams);   

}
