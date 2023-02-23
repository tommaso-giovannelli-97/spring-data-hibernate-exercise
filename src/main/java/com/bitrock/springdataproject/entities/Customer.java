package com.bitrock.springdataproject.entities;

import com.bitrock.springdataproject.dtos.CustomerProjectsCount;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @OneToMany(mappedBy = "customer")
    private Set<Project> projects;

    public static Customer from(CustomerProjectsCount customerProjectsCount) {
        return new Customer(customerProjectsCount.getCustomerId()
                , customerProjectsCount.getCustomerName(), null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId()) && getCustomerName().equals(customer.getCustomerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerName());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
