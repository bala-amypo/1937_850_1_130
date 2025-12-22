package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private boolean stolen;

    // Constructors
    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(String serialNumber, boolean stolen) {
        this.serialNumber = serialNumber;
        this.stolen = stolen;
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
}
