package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertRecordRepository {
    FraudAlertRecord save(FraudAlertRecord alert);
    List<FraudAlertRecord> findByClaimId(Long claimId);
}
