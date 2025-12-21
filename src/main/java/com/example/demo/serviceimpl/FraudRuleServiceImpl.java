package com.example.demo.service;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    // REQUIRED constructor
    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (repository.findByRuleCode(rule.getRuleCode()).isPresent()) {
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
        return repository.findByRuleCode(rulecode)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}