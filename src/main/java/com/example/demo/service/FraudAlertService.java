package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord createAlert(FraudAlertRecord alert);

    List<FraudAlertRecord> getAllAlerts();

    FraudAlertRecord getAlertById(Long id);

    List<FraudAlertRecord> getAlertsBySerial(String serialNumber);

    List<FraudAlertRecord> getAlertsByClaim(Long claimId);

    FraudAlertRecord resolveAlert(Long alertId);
}
