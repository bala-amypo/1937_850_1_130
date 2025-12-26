package com.example.demo.controller;

import com.example.demo.service.impl.FraudRuleServiceImpl;

public class FraudRuleController {

    private final FraudRuleServiceImpl service;

    public FraudRuleController(FraudRuleServiceImpl service) {
        this.service = service;
    }
}
