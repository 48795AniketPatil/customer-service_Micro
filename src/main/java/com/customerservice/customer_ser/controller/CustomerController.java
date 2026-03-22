package com.customerservice.customer_ser.controller;

import com.customerservice.customer_ser.dto.CustomerRequestDTO;
import com.customerservice.customer_ser.dto.CustomerResponseDTO;
import com.customerservice.customer_ser.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Customer API endpoints.
 * Handles HTTP requests and delegates all logic to CustomerService.
 * No business logic lives here — only routing and response wrapping.
 *
 * Base URL: /api/customers
 */
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * POST /api/customers/register
     * Registers a new customer in the system.
     *
     * Request Body: { name, email, phone, password }
     * Response: 201 Created with customer details (no password)
     */
    @PostMapping("/register")
    public ResponseEntity<CustomerResponseDTO> registerCustomer(@Valid @RequestBody CustomerRequestDTO dto) {
        CustomerResponseDTO response = customerService.registerCustomer(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * GET /api/customers/{id}
     * Fetches a customer by their ID.
     *
     * Response: 200 OK with customer details
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id) {
        CustomerResponseDTO response = customerService.getCustomerById(id);
        return ResponseEntity.ok(response);
    }
}
