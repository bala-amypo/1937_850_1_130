package com.example.demo.serviceimpl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    // ⚠️ DO NOT CHANGE ORDER – TESTS DEPEND ON THIS
    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository claimRepo,
            DeviceOwnershipRecordRepository deviceRepo,
            StolenDeviceReportRepository stolenRepo,
            FraudAlertRecordRepository alertRepo,
            FraudRuleRepository ruleRepo
    ) {
        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
        this.alertRepo = alertRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        if (!deviceRepo.existsBySerialNumber(claim.getSerialNumber())) {
            throw new NoSuchElementException("Device not found");
        }

        claim.setStatus("PENDING");
        WarrantyClaimRecord savedClaim = claimRepo.save(claim);

        // Flag stolen device
        if (stolenRepo.existsBySerialNumber(claim.getSerialNumber())) {
            createAlert(savedClaim, "STOLEN_DEVICE", "HIGH");
        }

        // Flag duplicate claim reason
        if (claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason())) {
            createAlert(savedClaim, "DUPLICATE_CLAIM", "MEDIUM");
        }

        return savedClaim;
    }

    private void createAlert(WarrantyClaimRecord claim, String type, String severity) {
        FraudAlertRecord alert = new FraudAlertRecord();
        alert.setClaimId(claim.getId());
        alert.setSerialNumber(claim.getSerialNumber());
        alert.setAlertType(type);
        alert.setSeverity(severity);
        alert.setMessage(type + " detected");
        alert.setAlertDate(LocalDateTime.now());
        alert.setResolved(false);
        alertRepo.save(alert);

        claim.setStatus("FLAGGED");
        claimRepo.save(claim);
    }

    @Override
    public void updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = getClaimById(claimId);
        claim.setStatus(status);
        claimRepo.save(claim);
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
