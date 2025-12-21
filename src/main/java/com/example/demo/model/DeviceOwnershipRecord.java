package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private boolean active;
    private String warrantyExpiration;  // yyyy-MM-dd
    private String status;  // NEW: for warranty status or other use

    // --- GETTERS & SETTERS ---

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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(String warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
