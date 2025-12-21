package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    // ⚠️ REQUIRED constructor order
    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository claimRepo,
            DeviceOwnershipRecordRepository deviceRepo,
            StolenDeviceReportRepository stolenRepo,
            FraudAlertRecordRepository alertRepo,
            FraudRuleRepository ruleRepo) {

        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
        this.alertRepo = alertRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        if (!device.getActive()) {
            throw new IllegalArgumentException("Inactive device");
        }

        boolean flagged = false;

        if (stolenRepo.existsBySerialNumber(claim.getSerialNumber())) {
            flagged = true;
        }

        if (device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            flagged = true;
        }

        if (claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason())) {
            flagged = true;
        }

        claim.setStatus(flagged ? "FLAGGED" : "PENDING");
        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new NoSuchElementException("Claim not found"));
        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Claim not found"));
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }
}