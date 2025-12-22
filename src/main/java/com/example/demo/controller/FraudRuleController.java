package com.example.demo.controller;

import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud-rule")
public class FraudRuleController {

    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @GetMapping("/evaluate")
    public boolean evaluateRule(
            @RequestParam String ruleName,
            @RequestParam String input) {

        return fraudRuleService.evaluateRule(ruleName, input);
    }
}
