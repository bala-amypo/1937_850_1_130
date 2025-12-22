package com.example.demo.serviceimpl;

import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl {

    @Autowired
    private DeviceOwnershipRecordRepository deviceRepository;

    public boolean checkDeviceExists(String serialNumber) {
        return deviceRepository.existsBySerialNumber(serialNumber);
    }
}
