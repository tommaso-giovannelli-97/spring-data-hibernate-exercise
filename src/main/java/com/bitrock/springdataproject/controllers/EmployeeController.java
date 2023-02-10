package com.bitrock.springdataproject.controllers;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Employee> save(@RequestBody Employee employee) {
            return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Employee> update(@RequestParam Long employeeId,  @RequestBody Employee employee) throws Exception {
        return new ResponseEntity<>(employeeService.update(employeeId, employee), HttpStatus.CREATED);
    }
}
