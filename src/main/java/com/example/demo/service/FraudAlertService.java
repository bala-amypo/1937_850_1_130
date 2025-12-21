package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord createAlert(FraudAlertRecord alert);

    FraudAlertRecord resolveAlert(long id);

    List<FraudAlertRecord> getAlertsBySerial(String serialNumber);

    List<FraudAlertRecord> getAlertsByClaim(long claimId);

    List<FraudAlertRecord> getAllAlerts();
}