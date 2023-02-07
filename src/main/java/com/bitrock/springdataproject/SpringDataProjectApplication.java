package com.bitrock.springdataproject;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataProjectApplication {
	//@Autowired
	//EmployeeService employeeService;

	public static void main(String[] args) {

		SpringApplication.run(SpringDataProjectApplication.class, args);



		//employeeService.create(new Employee("Tommaso", "Giovannelli", 25));
	}

}
