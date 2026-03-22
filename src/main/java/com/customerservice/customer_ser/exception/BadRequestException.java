package com.customerservice.customer_ser.exception;

/**
 * Custom exception thrown when a business rule is violated.
 * Example: Trying to make a payment on a PENDING or REJECTED loan.
 * Results in HTTP 400 response via GlobalExceptionHandler.
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
