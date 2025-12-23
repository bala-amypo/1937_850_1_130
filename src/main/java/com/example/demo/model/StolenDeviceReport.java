package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_report")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    private String reportedBy;

    private LocalDateTime reportDate;

    private String details;

    @PrePersist
    protected void onCreate() {
        this.reportDate = LocalDateTime.now();
    }

    public StolenDeviceReport() {
    }

    // getters and setters
}
