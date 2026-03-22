package com.customerservice.customer_ser.service;

import com.customerservice.customer_ser.dto.CustomerRequestDTO;
import com.customerservice.customer_ser.dto.CustomerResponseDTO;
import com.customerservice.customer_ser.exception.BadRequestException;
import com.customerservice.customer_ser.exception.ResourceNotFoundException;
import com.customerservice.customer_ser.model.Customer;
import com.customerservice.customer_ser.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service layer for Customer operations.
 * Contains all business logic related to customer registration and retrieval.
 * Controllers call this service — no business logic lives in the controller.
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Registers a new customer after checking for duplicate email.
     * Maps DTO -> Entity -> saves -> maps back to ResponseDTO.
     */
    public CustomerResponseDTO registerCustomer(CustomerRequestDTO dto) {

        // Check if email already exists
        customerRepository.findByEmail(dto.getEmail()).ifPresent(existing -> {
            throw new BadRequestException("Email already registered: " + dto.getEmail());
        });

        // Map DTO to entity
        Customer customer = Customer.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .password(dto.getPassword()) // In production, hash the password with BCrypt
                .build();

        Customer saved = customerRepository.save(customer);
        return mapToResponse(saved);
    }

    /**
     * Fetches a customer by ID.
     * Throws ResourceNotFoundException (HTTP 404) if not found.
     */
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return mapToResponse(customer);
    }

    /**
     * Helper: Maps Customer entity to CustomerResponseDTO.
     * Password is excluded from the response.
     */
    private CustomerResponseDTO mapToResponse(Customer customer) {
        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}
