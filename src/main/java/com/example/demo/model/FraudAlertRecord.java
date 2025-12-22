package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 REQUIRED FIELD (this fixes your crash)
    @Column(nullable = false)
    private Long claimId;

    @Column(nullable = false)
    private String message;

    public FraudAlertRecord() {
    }

    public FraudAlertRecord(Long claimId, String message) {
        this.claimId = claimId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
