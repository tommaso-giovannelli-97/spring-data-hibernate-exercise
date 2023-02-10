package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Customer;
import org.hibernate.Session;

public class CustomerService extends BaseDbService<Customer>{
    
    public void updateCustomer(Long customerId, Customer customer) {
        Session session = getSession();
        Customer oldCustomer = getById("Select c from Customer c where c.id = :id", customerId);

        if(oldCustomer != null) {
            customer.setId(customerId);
            session.update(customer);
            session.flush(); //To make update work!
        }
        session.close();
    }
}
