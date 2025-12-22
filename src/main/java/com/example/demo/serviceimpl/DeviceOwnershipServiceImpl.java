package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository deviceRepository;

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean stolen) {
        DeviceOwnershipRecord record = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        record.setStolen(stolen);
        return deviceRepository.save(record);
    }
}
