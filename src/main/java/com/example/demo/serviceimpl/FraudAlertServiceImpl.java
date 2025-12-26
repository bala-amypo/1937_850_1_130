package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.util.*;

public class FraudAlertServiceImpl {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository r) {
        repo = r;
    }

    public FraudAlertRecord createAlert(FraudAlertRecord a) {
        return repo.save(a);
    }

    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord a = repo.findById(id).orElseThrow();
        a.setResolved(true);
        return repo.save(a);
    }

    public List<FraudAlertRecord> getAlertsByClaim(Long id) {
        return repo.findByClaimId(id);
    }
}
