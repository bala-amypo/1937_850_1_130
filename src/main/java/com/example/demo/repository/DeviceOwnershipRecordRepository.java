package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {

    // Find a device by serial number
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);

    // Check if a device exists by serial number
    boolean existsBySerialNumber(String serialNumber);
}
