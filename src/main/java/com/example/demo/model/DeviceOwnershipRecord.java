package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository deviceRepository;

    @Autowired
    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean stolen) {
        Optional<DeviceOwnershipRecord> optionalRecord = deviceRepository.findById(id);
        if (optionalRecord.isPresent()) {
            DeviceOwnershipRecord record = optionalRecord.get();
            record.setStolen(stolen); // Make sure your DeviceOwnershipRecord model has setStolen()
            return deviceRepository.save(record);
        } else {
            throw new RuntimeException("Device not found with id: " + id);
        }
    }
}
