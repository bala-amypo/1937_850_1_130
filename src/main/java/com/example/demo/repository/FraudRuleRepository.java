package com.example.demo.repository;

import com.example.demo.model.FraudRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudRuleRepository
        extends JpaRepository<FraudRule, Long> {

    List<FraudRule> findByActiveTrue();

    FraudRule findByRuleCode(String ruleCode);
}
