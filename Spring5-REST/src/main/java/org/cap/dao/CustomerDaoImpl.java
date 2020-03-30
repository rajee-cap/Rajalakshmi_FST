package org.cap.dao;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.utility.UtilityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ReflectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao{
	
	@Autowired
	UtilityBean beanUtils;
	private static AtomicInteger customerId=new AtomicInteger(1);
	private static AtomicInteger accountNo=new AtomicInteger(1000);
	private static List<Customer> customerDummyDb=dummyDB();
	ObjectMapper objectMapper= new ObjectMapper();
	
	
			
	private static List<Customer> dummyDB(){
		List<Customer> customers=new ArrayList<>();
			customers.add(new Customer(customerId.getAndIncrement(), "TOm", "32434324",
					new Account(accountNo.getAndIncrement(), "Savings", LocalDate.of(2000, 2, 12), 23000)));
		
			customers.add(new Customer(customerId.getAndIncrement(), "Thomson", "8676889",
					new Account(accountNo.getAndIncrement(), "Savings", LocalDate.of(2020, 3, 21), 3000)));
			
			customers.add(new Customer(customerId.getAndIncrement(), "Alwin", "6787878",
					new Account(accountNo.getAndIncrement(), "Current", LocalDate.of(2020, 2, 11), 5600)));
			
			customers.add(new Customer(customerId.getAndIncrement(), "Jack", "4535435",null));
		return customers;
	}
	
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerDummyDb;
	}


	@Override
	public List<Customer> createCustomer(Customer customer) {
		customerDummyDb.add(customer);
		return customerDummyDb;
	}


	@Override
	public List<Customer> deleteCustomer(long id) {
		for(Customer customer:customerDummyDb) {
			if(customer.getCustomerId()==id) {
				customerDummyDb.remove(customer);
				break;
			}
		}
		return customerDummyDb;
	}


	@Override
	public List<Customer> updateCustomer(Customer customer, long id) {
		for(Customer mcustomer:customerDummyDb) {
			if(mcustomer.getCustomerId()==id) {
				customerDummyDb.remove(mcustomer);
				break;
			}
		}
		customerDummyDb.add(customer);
		return customerDummyDb;
	}


	@Override
	public List<Customer> updatePatchCustomer(long id, MultiValueMap<Object, Object> formParams) {
		Customer toBePatchedCustomer = objectMapper.convertValue(formParams, Customer.class);
        return patch(toBePatchedCustomer,id);
		
	}
	
	public Customer findCustomer(long id) {
		for(Customer customer:customerDummyDb) {
			if(customer.getCustomerId()==id) {
				return customer;
			}
		}
		return null;
	}
	
	public List<Customer> patch(Customer toBePatched,long id) {
		Customer customer= findCustomer(id);
        try {
			beanUtils.copyProperties(customer, toBePatched);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return updateCustomer(customer,id);
    }
	

}
