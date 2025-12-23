package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord createAlert(FraudAlertRecord alert);

    void resolveAlert(long id);

    List<FraudAlertRecord> getAlertsBySerial(String serialNumber);

    List<FraudAlertRecord> getAlertsByClaim(long claimId);

    FraudAlertRecord getAlertById(long id);

    List<FraudAlertRecord> getAllAlerts();
}
