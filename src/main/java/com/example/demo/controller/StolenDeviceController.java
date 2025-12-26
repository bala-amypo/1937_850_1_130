package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.impl.StolenDeviceServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stolen")
public class StolenDeviceController {

    private final StolenDeviceServiceImpl stolenService;

    public StolenDeviceController(StolenDeviceServiceImpl stolenService) {
        this.stolenService = stolenService;
    }

    @PostMapping("/report")
    public StolenDeviceReport reportStolen(@RequestBody StolenDeviceReport report) {
        return stolenService.reportStolen(report);
    }

    @GetMapping("/{serialNumber}")
    public List<StolenDeviceReport> getReportsBySerial(@PathVariable String serialNumber) {
        return stolenService.getReportsBySerial(serialNumber);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return stolenService.getAllReports();
    }
}
