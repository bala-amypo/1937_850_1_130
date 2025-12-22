package com.example.demo.controller;

import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudAlertController {

    private final FraudAlertService fraudAlertService;

    public FraudAlertController(FraudAlertService fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }

    @GetMapping("/alert")
    public String triggerAlert(@RequestParam String message) {
        fraudAlertService.sendAlert(message);
        return "Alert triggered successfully!";
    }
}
