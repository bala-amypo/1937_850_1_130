package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import java.util.Optional;

public interface FraudAlertRecordRepository {
    FraudAlertRecord save(FraudAlertRecord alert);
    Optional<FraudAlertRecord> findById(Long id);
}
