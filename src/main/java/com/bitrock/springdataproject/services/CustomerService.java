package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.dtos.CustomerProjectsCount;
import com.bitrock.springdataproject.entities.Customer;
import com.bitrock.springdataproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService extends BaseDbService<Customer> {

    //Repository for Custom methods
    @Autowired
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }

    public List<Customer> getAllOrderedByNumberOfProjects(){
        List<Customer> orderedCustomers = new ArrayList<>();
        List<CustomerProjectsCount> customerProjects = customerRepository.getAllOrderedByNumberOfProjects();
        customerProjects.forEach(c -> orderedCustomers.add(Customer.from(c)));
        return orderedCustomers;
    }
}
