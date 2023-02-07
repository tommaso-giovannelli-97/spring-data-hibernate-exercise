package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
