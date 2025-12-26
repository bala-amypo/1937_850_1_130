package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.util.*;

public class FraudRuleServiceImpl {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository r) {
        repo = r;
    }

    public FraudRule createRule(FraudRule r) {
        if (repo.findByRuleCode(r.getRuleCode()).isPresent())
            throw new IllegalArgumentException();
        return repo.save(r);
    }

    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public Optional<FraudRule> getRuleByCode(String c) {
        return repo.findByRuleCode(c);
    }
}
