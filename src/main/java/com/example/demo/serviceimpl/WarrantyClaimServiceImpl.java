package com.example.demo.serviceimpl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.repository.WarrantyClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WarrantyClaimServiceImpl {

    @Autowired
    private WarrantyClaimRepository warrantyClaimRepository;

    @Autowired
    private FraudAlertRepository fraudAlertRepository;

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        claim.setSubmittedAt(LocalDateTime.now());
        claim.setStatus("PENDING");
        warrantyClaimRepository.save(claim);

        // Generate fraud alert
        FraudAlertRecord alert = new FraudAlertRecord();
        alert.setClaimId(claim.getId());
        alert.setSerialNumber(claim.getSerialNumber());
        alert.setAlertType("WARRANTY_CLAIM");
        alert.setSeverity("MEDIUM");
        alert.setMessage(claim.getClaimReason());
        alert.setAlertDate(LocalDateTime.now());
        alert.setResolved(false);

        fraudAlertRepository.save(alert);

        return claim;
    }

    public WarrantyClaimRecord updateClaimStatus(WarrantyClaimRecord claim, String status) {
        claim.setStatus(status);
        return warrantyClaimRepository.save(claim);
    }
}
