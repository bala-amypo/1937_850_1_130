package com.example.demo.service;

import com.example.demo.model.FraudRule;
import java.util.List;

public interface FraudRuleService {

    FraudRule createRule(FraudRule rule);

    FraudRule updateRule(Long id, FraudRule updatedRule);

    List<FraudRule> getActiveRules();

    FraudRule getRulebyccode(String rulecode);

    List<FraudRule> getAllRules();
}
