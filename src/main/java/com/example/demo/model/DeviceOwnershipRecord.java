package com.example.demo.model;

public class DeviceOwnershipRecord {
    private Long id;
    private String serialNumber;
    private boolean active;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
