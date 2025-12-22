package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WarrantyClaimServiceImpl {

    @Autowired
    private DeviceOwnershipRecordRepository deviceRepository;

    public String checkWarranty(Long deviceId) {
        DeviceOwnershipRecord device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        if (device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            device.setStatus("Expired");
            deviceRepository.save(device);
            return "Warranty expired";
        } else {
            device.setStatus("Valid");
            deviceRepository.save(device);
            return "Warranty valid";
        }
    }
}
