package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String serialNumber;

    @NotBlank
    private String claimantName;

    @Email
    private String claimantEmail;

    @NotBlank
    private String claimReason;

    private LocalDateTime submittedAt;
    private String status;

    @PrePersist
    void onCreate() {
        submittedAt = LocalDateTime.now();
        status = "PENDING";
    }
}