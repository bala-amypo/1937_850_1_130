package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
@Tag(name = "Stolen Devices")
public class StolenDeviceController {

    private final StolenDeviceService stolenDeviceService;

    public StolenDeviceController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    @PostMapping
    public StolenDeviceReport reportStolen(@RequestBody StolenDeviceReport report) {
        return stolenDeviceService.reportStolen(report);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerial(@PathVariable String serialNumber) {
        return stolenDeviceService.getReportsBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return stolenDeviceService.getReportById(id);
    }

    @GetMapping
    public List<StolenDeviceReport> getAll() {
        return stolenDeviceService.getAllReports();
    }
}
