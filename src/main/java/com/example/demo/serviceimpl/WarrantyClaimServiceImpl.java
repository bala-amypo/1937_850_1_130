package com.example.demo.serviceimpl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    // ✅ REQUIRED METHOD (THIS FIXES YOUR ERROR)
    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        // TEMP implementation so project COMPILES
        return new ArrayList<>();
    }

    // ✅ WARRANTY CHECK METHOD (NO ERROR)
    public void checkWarranty(DeviceOwnershipRecord device) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate warrantyDate = LocalDate.parse(device.getWarrantyExpiration(), formatter);

        if (warrantyDate.isBefore(LocalDate.now())) {
            device.setStatus("Expired");
        } else {
            device.setStatus("Valid");
        }
    }
}
