package com.example.demo.serviceimpl;

import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final DeviceOwnershipRecordRepository repository;

    public StolenDeviceServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isDeviceStolen(String serialNumber) {
        return repository.existsBySerialNumber(serialNumber);
    }
}
