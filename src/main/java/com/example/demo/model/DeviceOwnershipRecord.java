package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private boolean stolen;

    private LocalDate warrantyExpiration; // Add this

    private String status; // Add this

    // Constructors
    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(String serialNumber, boolean stolen, LocalDate warrantyExpiration, String status) {
        this.serialNumber = serialNumber;
        this.stolen = stolen;
        this.warrantyExpiration = warrantyExpiration;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isStolen() {
        return stolen;
    }

    public void setStolen(boolean stolen) {
        this.stolen = stolen;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
