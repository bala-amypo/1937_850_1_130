package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {
    
    // Checks if a device with the given serial number exists
    boolean existsBySerialNumber(String serialNumber);
    
    // You can add more custom queries if needed, for example:
    // Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}
