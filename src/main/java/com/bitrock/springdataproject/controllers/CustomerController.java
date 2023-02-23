package com.bitrock.springdataproject.controllers;

import com.bitrock.springdataproject.entities.Customer;
import com.bitrock.springdataproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    ResponseEntity<List<Customer>> getAllOrderedByNumberOfProjects() {
        return new ResponseEntity<>(customerService.getAllOrderedByNumberOfProjects(), HttpStatus.OK);
    }

}
