package com.example.demo.controller;

import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudRuleController {

    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    // Example endpoint
    // @GetMapping("/evaluate/{claimId}")
    public void evaluate(String claimId) {
        fraudRuleService.evaluateRule(claimId);
    }
}
