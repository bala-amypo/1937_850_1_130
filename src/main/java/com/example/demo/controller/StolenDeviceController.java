package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.impl.StolenDeviceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceServiceImpl stolenDeviceService;

    public StolenDeviceController(StolenDeviceServiceImpl stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    @PostMapping("/report")
    public ResponseEntity<StolenDeviceReport> reportStolen(@RequestBody StolenDeviceReport report) {
        StolenDeviceReport saved = stolenDeviceService.reportStolen(report);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{serial}")
    public ResponseEntity<List<StolenDeviceReport>> getReportsBySerial(@PathVariable String serial) {
        return ResponseEntity.ok(stolenDeviceService.getReportsBySerial(serial));
    }

    @GetMapping
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(stolenDeviceService.getAllReports());
    }
}
