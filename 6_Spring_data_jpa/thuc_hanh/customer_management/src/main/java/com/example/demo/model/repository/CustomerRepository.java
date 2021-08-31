package com.example.demo.model.repository;

import com.example.demo.model.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value= "call insert_into_customer{:inputFirstName, :inputLastName}", nativeQuery = true)
    Boolean insertIntoCustomer(@Param("inputFirstName") String firstName,
                               @Param("inputLastName") String lastName);
}
