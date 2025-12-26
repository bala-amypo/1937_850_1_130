package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.time.LocalDate;
import java.util.*;

public class WarrantyClaimServiceImpl {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    public WarrantyClaimServiceImpl(
        WarrantyClaimRecordRepository c,
        DeviceOwnershipRecordRepository d,
        StolenDeviceReportRepository s,
        FraudAlertRecordRepository a,
        FraudRuleRepository r) {

        claimRepo = c; deviceRepo = d; stolenRepo = s; alertRepo = a; ruleRepo = r;
    }

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord c) {
        DeviceOwnershipRecord d = deviceRepo.findBySerialNumber(c.getSerialNumber())
                .orElseThrow();

        boolean flag =
            claimRepo.existsBySerialNumberAndClaimReason(c.getSerialNumber(), c.getClaimReason()) ||
            d.getWarrantyExpiration().isBefore(LocalDate.now()) ||
            stolenRepo.existsBySerialNumber(c.getSerialNumber());

        if (flag) c.setStatus("FLAGGED");
        return claimRepo.save(c);
    }

    public WarrantyClaimRecord updateClaimStatus(Long id, String s) {
        WarrantyClaimRecord c = claimRepo.findById(id).orElseThrow();
        c.setStatus(s);
        return claimRepo.save(c);
    }

    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }

    public List<WarrantyClaimRecord> getClaimsBySerial(String s) {
        return claimRepo.findBySerialNumber(s);
    }
}
