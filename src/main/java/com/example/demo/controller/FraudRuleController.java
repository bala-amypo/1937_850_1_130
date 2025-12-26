package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.impl.FraudRuleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    private final FraudRuleServiceImpl fraudRuleService;

    public FraudRuleController(FraudRuleServiceImpl fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @GetMapping("/active")
    public ResponseEntity<List<FraudRule>> getActiveRules() {
        return ResponseEntity.ok(fraudRuleService.getActiveRules());
    }

    @GetMapping("/{code}")
    public ResponseEntity<FraudRule> getRuleByCode(@PathVariable String code) {
        Optional<FraudRule> rule = fraudRuleService.getRuleByCode(code);
        return rule.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FraudRule> createRule(@RequestBody FraudRule rule) {
        FraudRule saved = fraudRuleService.createRule(rule);
        return ResponseEntity.ok(saved);
    }
}
