package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Customer;
import com.bitrock.springdataproject.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseDbService<Customer> {

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}
