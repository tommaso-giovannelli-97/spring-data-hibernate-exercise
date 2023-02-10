package com.bitrock.springdataproject;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.services.EmployeeService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        final String getAllEmployeeHql = "Select e from Employee e";
        final String getEmployeeByIdHql = "Select e from Employee e where e.id = :id";

        EmployeeService employeeService = new EmployeeService();

        List<Employee> allEmployees = employeeService.getAll(getAllEmployeeHql);
        allEmployees.forEach(System.out::println);
        Employee employeeById = employeeService.getById(getEmployeeByIdHql,2L);

        Employee newEmployee = new Employee("Mario","Rossi",45);
        employeeService.updateEmployee(2L, newEmployee);
    }
}
