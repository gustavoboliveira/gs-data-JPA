package com.example.gsDataJPA.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.gsDataJPA.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Collection<Customer> findAll();
	
	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}
