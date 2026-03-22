package com.customerservice.customer_ser.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO for outgoing customer data in API responses.
 * Password is intentionally excluded to avoid exposing sensitive data.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
}
