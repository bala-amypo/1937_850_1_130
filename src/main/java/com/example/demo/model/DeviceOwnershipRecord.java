package com.example.demo.model;

import java.time.LocalDate;

public class DeviceOwnershipRecord {

    private Long id;
    private String serialNumber;
    private boolean active;
    private LocalDate warrantyExpiration;

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDate getWarrantyExpiration() { return warrantyExpiration; }
    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }
}
