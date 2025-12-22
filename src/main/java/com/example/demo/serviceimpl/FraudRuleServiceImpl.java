package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import java.util.List;
import java.util.NoSuchElementException;

public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (repository.findByRuleCode(rule.getRuleCode()) != null) {
            throw new IllegalArgumentException("Duplicate rule code");
        }
        return repository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        FraudRule rule = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        rule.setDescription(updatedRule.getDescription());
        rule.setRuleType(updatedRule.getRuleType());
        rule.setActive(updatedRule.getActive());

        return repository.save(rule);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public FraudRule getRulebyccode(String rulecode) {
        FraudRule rule = repository.findByRuleCode(rulecode);
        if (rule == null) {
            throw new NoSuchElementException("Rule not found");
        }
        return rule;
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}
