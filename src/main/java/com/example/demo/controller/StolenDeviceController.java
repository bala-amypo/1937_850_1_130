package com.example.demo.controller;

import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StolenDeviceController {

    private final StolenDeviceService stolenDeviceService;

    public StolenDeviceController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    // Example endpoint
    public void report(String serial) {
        stolenDeviceService.reportStolenDevice(serial);
    }
}
