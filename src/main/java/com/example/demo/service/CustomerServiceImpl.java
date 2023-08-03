package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
@Service

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.customerRepository.save(customer);
		
	}
	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> optional =customerRepository.findById(id);
		Customer customer=null;
		if(optional.isPresent()) {
			customer=optional.get();
		}
		else {
			throw new RuntimeException("customer not found for id::"+ id);
		}
		return customer;
	}

	@Override
	public void deleteCustomerById(long id) {
		this.customerRepository.deleteById(id);
	}
}
