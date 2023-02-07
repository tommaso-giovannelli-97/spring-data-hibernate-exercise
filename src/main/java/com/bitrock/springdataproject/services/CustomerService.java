package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Customer;
import com.bitrock.springdataproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> findAll () {
        return repository.findAll();
    }

    public Customer findById(Long customerId) {
        Optional<Customer> optionalCustomer = repository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    public Customer update(Long customerId, Customer customer) throws Exception {
        Optional<Customer> optionalCustomer = repository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new Exception("No existing Customer with the given id");
        }
        return repository.save(customer);
    }

    public void delete(Long customerId) {
        repository.deleteById(customerId);
    }
}
