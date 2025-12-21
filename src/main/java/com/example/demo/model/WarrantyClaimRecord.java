package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimReason;
    private String status;

    private LocalDateTime submittedAt;

    @PrePersist
    void onCreate() {
        this.submittedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
