package com.example.demo.serviceimpl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository alertRepo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository alertRepo) {
        this.alertRepo = alertRepo;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return alertRepo.save(alert);
    }

    @Override
    public void resolveAlert(long id) {
        FraudAlertRecord alert = getAlertById(id);
        alert.setResolved(true);
        alertRepo.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
        return alertRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecord> getAlertsByClaim(long claimId) {
        return alertRepo.findByClaimId(claimId);
    }

    @Override
    public FraudAlertRecord getAlertById(long id) {
        return alertRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Alert not found"));
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return alertRepo.findAll();
    }
}
