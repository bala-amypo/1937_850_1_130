package com.example.demo.serviceimpl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository repository;

    public FraudAlertServiceImpl(FraudAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public FraudAlertRecord getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repository.findByClaimId(claimId);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long alertId) {
        FraudAlertRecord alert = repository.findById(alertId).orElse(null);
        if (alert != null) {
            alert.setResolved(true);
            return repository.save(alert);
        }
        return null;
    }
}
