package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    // REQUIRED constructor
    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        if (repository.existsBySerialNumber(device.getSerialNumber())) {
            throw new IllegalArgumentException("Duplicate serial number");
        }
        return repository.save(device);
    }

    @Override
    public DeviceOwnershipRecord getBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord device = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
        device.setActive(active);
        return repository.save(device);
    }
}