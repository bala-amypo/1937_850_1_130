package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.impl.FraudAlertServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class FraudAlertController {

    private final FraudAlertServiceImpl alertService;

    public FraudAlertController(FraudAlertServiceImpl alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/create")
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return alertService.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolveAlert(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }

    @GetMapping("/by-claim/{claimId}")
    public List<FraudAlertRecord> getAlertsByClaim(@PathVariable Long claimId) {
        return alertService.getAlertsByClaim(claimId);
    }
}
