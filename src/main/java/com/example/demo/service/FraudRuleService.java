package com.example.demo.service;

import com.example.demo.model.FraudRule;

import java.util.List;

public interface FraudRuleService {

    FraudRule createRule(FraudRule rule);

    FraudRule updateRule(Long id, FraudRule updatedRule);

    List<FraudRule> getActiveRules();

    FraudRule getRuleByCode(String ruleCode);

    FraudRule getRuleById(Long id);

    List<FraudRule> getAllRules();
}
