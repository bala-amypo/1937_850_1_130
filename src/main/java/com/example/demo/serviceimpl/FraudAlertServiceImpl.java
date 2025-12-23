package com.example.demo.serviceimpl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository fraudAlertRepository;

    public FraudAlertServiceImpl(FraudAlertRepository fraudAlertRepository) {
        this.fraudAlertRepository = fraudAlertRepository;
    }

    @Override
    public FraudAlertRecord save(FraudAlertRecord alert) {
        return fraudAlertRepository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> findAll() {
        return fraudAlertRepository.findAll();
    }
}
