package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WarrantyClaimServiceImpl {

    @Autowired
    private DeviceOwnershipRecordRepository deviceRepository;

    public void updateWarrantyStatus() {
        List<DeviceOwnershipRecord> devices = deviceRepository.findAll();
        for(DeviceOwnershipRecord device : devices) {
            if(device.getWarrantyExpiration() != null) {
                if(device.getWarrantyExpiration().isBefore(LocalDate.now())) {
                    device.setStatus("Expired");
                } else {
                    device.setStatus("Active");
                }
                deviceRepository.save(device);
            }
        }
    }
}
