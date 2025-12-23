package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_record")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;

    private String serialNumber;

    private String alertType;

    private String severity;

    private String message;

    private LocalDateTime alertDate;

    private Boolean resolved;

    @PrePersist
    protected void onCreate() {
        this.alertDate = LocalDateTime.now();
        this.resolved = false;
    }

    public FraudAlertRecord() {
    }

    // getters and setters
}
