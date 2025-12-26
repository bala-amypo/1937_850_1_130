package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.impl.FraudAlertServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertServiceImpl fraudAlertService;

    public FraudAlertController(FraudAlertServiceImpl fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }

    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsByClaim(@PathVariable Long claimId) {
        return ResponseEntity.ok(fraudAlertService.getAlertsByClaim(claimId));
    }

    @PostMapping
    public ResponseEntity<FraudAlertRecord> createAlert(@RequestBody FraudAlertRecord alert) {
        FraudAlertRecord saved = fraudAlertService.createAlert(alert);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/resolve/{id}")
    public ResponseEntity<FraudAlertRecord> resolveAlert(@PathVariable Long id) {
        FraudAlertRecord resolved = fraudAlertService.resolveAlert(id);
        return ResponseEntity.ok(resolved);
    }
}
