package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerService {
    private final Session session;

    public CustomerService(Session session) {
        this.session = session;
    }

    public List<Customer> getAllCustomers() {
        String hqlQuery = "Select c from Customer c";
        Query query = session.createQuery(hqlQuery);
        return query.getResultList();
    }

    public Customer getCustomerById(Long customerId) {
        String hqlQuery = "Select c from Customer c where c.id = :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id", customerId);
        return (Customer) query.uniqueResult();
    }

    public void createCustomer(Customer customer) {
        session.save(customer);
    }

    //To implement
    public void updateCustomer(Long customerId, Customer customer) {
    }

    public void deleteCustomerById(Long customerId) {
        String hqlQuery = "delete from Customer c where c.id= :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id",customerId);
        query.executeUpdate();
    }
}
