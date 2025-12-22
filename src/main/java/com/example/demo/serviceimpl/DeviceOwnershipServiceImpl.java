package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repository;

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record) {
        return repository.save(record);
    }

    @Override
    public void updateDeviceStatus(Long id, boolean stolen) {
        Optional<DeviceOwnershipRecord> optionalRecord = repository.findById(id);
        if(optionalRecord.isPresent()) {
            DeviceOwnershipRecord record = optionalRecord.get();
            record.setStolen(stolen);
            repository.save(record);
        }
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }
}
