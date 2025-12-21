package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repository;

    // REQUIRED constructor
    public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public FraudAlertRecord resolveAlert(long id) {
        FraudAlertRecord alert = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Alert not found"));
        alert.setResolved(true);
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
        return repository.findAll()
                .stream()
                .filter(a -> a.getSerialNumber().equals(serialNumber))
                .collect(Collectors.toList());
    }

    @Override
    public List<FraudAlertRecord> getAlertsByClaim(long claimId) {
        return repository.findByClaimId(claimId);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}