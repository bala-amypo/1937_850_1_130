package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    // --- Example method to check warranty ---
    public void checkWarranty(DeviceOwnershipRecord device) {
        // assume warrantyExpiration is stored as "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate warrantyDate = LocalDate.parse(device.getWarrantyExpiration(), formatter);

        if (warrantyDate.isBefore(LocalDate.now())) {
            // warranty expired
            System.out.println("Warranty expired");
            device.setStatus("Expired");
        } else {
            // warranty still valid
            System.out.println("Warranty valid");
            device.setStatus("Valid");
        }
    }

    // You can add other methods from WarrantyClaimService here
}
