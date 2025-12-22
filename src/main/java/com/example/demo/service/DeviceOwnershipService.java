package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;
import java.util.Optional;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record);

    void updateDeviceStatus(Long id, boolean stolen);

    Optional<DeviceOwnershipRecord> getBySerial(String serialNumber);

    List<DeviceOwnershipRecord> getAllDevices();
}
