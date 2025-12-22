package com.example.demo.serviceimpl;

import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    @Override
    public void evaluateRule(String claimId) {
        // Example implementation
        System.out.println("Evaluating fraud rule for claim: " + claimId);
    }
}
