package com.customerservice.customer_ser.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Standard error response body returned for all API errors.
 * Ensures consistent error format across all endpoints.
 */
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
}
