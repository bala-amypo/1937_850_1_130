package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.impl.FraudRuleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rules")
public class FraudRuleController {

    private final FraudRuleServiceImpl ruleService;

    public FraudRuleController(FraudRuleServiceImpl ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/create")
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping("/{ruleCode}")
    public Optional<FraudRule> getRuleByCode(@PathVariable String ruleCode) {
        return ruleService.getRuleByCode(ruleCode);
    }
}
