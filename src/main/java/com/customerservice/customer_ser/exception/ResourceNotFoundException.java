package com.customerservice.customer_ser.exception;

/**
 * Custom exception thrown when a requested resource is not found in the database.
 * Example: Customer with ID 5 does not exist.
 * Results in HTTP 404 response via GlobalExceptionHandler.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
