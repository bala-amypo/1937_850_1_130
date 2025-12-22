package com.example.demo.service;

public interface FraudRuleService {
    boolean evaluateRule(String ruleName, String input);
}
