package com.example.demo.serviceimpl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository ruleRepo;

    public FraudRuleServiceImpl(FraudRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        FraudRule rule = getRuleById(id);
        rule.setRuleCode(updatedRule.getRuleCode());
        rule.setDescription(updatedRule.getDescription());
        rule.setRuleType(updatedRule.getRuleType());
        rule.setActive(updatedRule.getActive());
        return ruleRepo.save(rule);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public FraudRule getRuleByCode(String ruleCode) {
        return ruleRepo.findByRuleCode(ruleCode)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public FraudRule getRuleById(Long id) {
        return ruleRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public List<FraudRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
