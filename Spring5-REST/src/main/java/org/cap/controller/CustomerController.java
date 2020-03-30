package org.cap.controller;

import java.util.List;

import org.cap.dao.ICustomerDao;
import org.cap.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/cust")
public class CustomerController {

	@Autowired
	private ICustomerDao customerDao;
	
	@PostMapping("/customers")
	public ResponseEntity<List<Customer>> createCustomer(
			@RequestBody Customer customer){
		List<Customer> customers= customerDao.createCustomer(customer);
		if(customers==null || customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customer Details Not Avilable!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, 
				HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers= customerDao.getAllCustomers();
		if(customers==null || customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customer Details Not Avilable!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, 
				HttpStatus.OK);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<List<Customer>> updateCustomer(
			@RequestBody Customer customer, @PathVariable long id){
		List<Customer> customers= customerDao.updateCustomer(customer,id);
		if(customers==null || customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customer Details Not Avilable!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable long id) {
		List<Customer> customers= customerDao.deleteCustomer(id);
		if(customers==null || customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customer Details Not Avilable!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, 
				HttpStatus.OK);
	}
	
	@PatchMapping(path = "/customers/{id}")
	public ResponseEntity<List<Customer>> updatePatchCustomer(@PathVariable long id, @RequestBody MultiValueMap<Object, Object> formParams) {
		List<Customer> customers= customerDao.updatePatchCustomer(id,formParams);
		if(customers==null || customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customer Details Not Avilable!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Customer>>(customers, 
				HttpStatus.OK);
	}
	
}
