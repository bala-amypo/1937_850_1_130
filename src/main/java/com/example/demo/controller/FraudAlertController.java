package com.example.demo.controller;

import com.example.demo.service.impl.FraudAlertServiceImpl;

public class FraudAlertController {

    private final FraudAlertServiceImpl service;

    public FraudAlertController(FraudAlertServiceImpl service) {
        this.service = service;
    }
}
