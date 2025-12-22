package com.example.demo.serviceimpl;

import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    @Override
    public boolean evaluateRule(String ruleName, String value) {
        // simple dummy logic
        return value != null && !value.isBlank();
    }
}
