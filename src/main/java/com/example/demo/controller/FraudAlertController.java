package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
@Tag(name = "Fraud Alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @PostMapping
    public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolve(@PathVariable long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getAlertsBySerial(serialNumber);
    }

    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> getByClaim(@PathVariable long claimId) {
        return service.getAlertsByClaim(claimId);
    }

    @GetMapping("/{id}")
    public FraudAlertRecord getById(@PathVariable long id) {
        return service.getAllAlerts()
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new java.util.NoSuchElementException("Alert not found"));
    }

    @GetMapping
    public List<FraudAlertRecord> getAll() {
        return service.getAllAlerts();
    }
}