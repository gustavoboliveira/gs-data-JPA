package com.example.gsDataJPA.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gsDataJPA.model.Customer;
import com.example.gsDataJPA.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/")
	public Collection<Customer> findAll(){
		Collection<Customer> customer = repository.findAll();
		return customer;
	}
	
	@GetMapping("/id/{id}")
	public Customer getCustomer(@PathVariable long id){
		Customer customer = repository.findById(id);
		return customer;
	}
	
	@GetMapping("/name/{lastName}")
	public List<Customer> findByLastName(@PathVariable String lastName){
		List<Customer> list = repository.findByLastName(lastName);
		return list;
	}
}
