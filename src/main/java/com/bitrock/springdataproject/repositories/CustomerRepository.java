package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.dtos.CustomerProjectsCount;
import com.bitrock.springdataproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c.id AS customerId, c.customerName AS customerName, COUNT(p.id) AS projectsNumber " +
            "FROM Customer c " +
            "LEFT OUTER JOIN c.projects p" +
            " GROUP BY c.id" +
            " ORDER BY projectsNumber DESC")
    List<CustomerProjectsCount> getAllOrderedByNumberOfProjects();
}
