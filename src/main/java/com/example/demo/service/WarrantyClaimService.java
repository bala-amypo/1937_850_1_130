package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord getClaimById(Long id);

    List<WarrantyClaimRecord> getAllClaims();

    List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);

    WarrantyClaimRecord updateClaimStatus(Long id, String status);

    WarrantyClaimRecord saveClaim(WarrantyClaimRecord record);
}
