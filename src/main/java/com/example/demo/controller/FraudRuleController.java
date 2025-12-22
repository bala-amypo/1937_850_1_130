package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
@Tag(name = "Fraud Rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public FraudRule updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/{ruleCode}")
    public FraudRule getByRuleCode(
            @PathVariable String ruleCode) {
        return service.getRulebyccode(ruleCode);
    }

    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }
}
