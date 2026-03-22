package com.customerservice.customer_ser.repository;

import com.customerservice.customer_ser.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repository interface for Customer entity.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Find a customer by ID.
     * Inherited from JpaRepository.
     * 
     * @param id the customer ID
     * @return Optional containing the customer if found
     */
    Optional<Customer> findById(Long id);

    /**
     * Find a customer by email address.
     * Spring Data JPA automatically generates the SQL query.
     * 
     * @param email the customer email
     * @return Optional containing the customer if found
     */
    Optional<Customer> findByEmail(String email);
}