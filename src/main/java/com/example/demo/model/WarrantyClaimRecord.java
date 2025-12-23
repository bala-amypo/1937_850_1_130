package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_record")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    private String claimantName;

    private String claimantEmail;

    private String claimReason;

    private LocalDateTime submittedAt;

    private String status;

    @PrePersist
    protected void onCreate() {
        this.submittedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public WarrantyClaimRecord() {
    }

    // getters and setters
}
