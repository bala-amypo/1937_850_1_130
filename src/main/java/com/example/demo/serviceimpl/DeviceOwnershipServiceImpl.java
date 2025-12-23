package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository deviceRepo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        if (deviceRepo.existsBySerialNumber(device.getSerialNumber())) {
            throw new IllegalArgumentException("Duplicate serial number");
        }
        return deviceRepo.save(device);
    }

    @Override
    public DeviceOwnershipRecord getBySerial(String serialNumber) {
        return deviceRepo.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
    }

    @Override
    public DeviceOwnershipRecord getById(Long id) {
        return deviceRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return deviceRepo.findAll();
    }

    @Override
    public void updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord device = getById(id);
        device.setActive(active);
        deviceRepo.save(device);
    }
}
