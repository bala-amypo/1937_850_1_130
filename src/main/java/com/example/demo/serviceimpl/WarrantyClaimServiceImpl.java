package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        return claim; // dummy logic for compilation
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord record = new WarrantyClaimRecord();
        record.setId(id);
        record.setStatus(status);
        return record;
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        WarrantyClaimRecord record = new WarrantyClaimRecord();
        record.setId(id);
        return record;
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return new ArrayList<>();
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return new ArrayList<>();
    }

    // ✅ WARRANTY CHECK (NO ERRORS)
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
