package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;

import java.util.List;

public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository repo,
            DeviceOwnershipRecordRepository deviceRepo) {

        this.repo = repo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        deviceRepo.findBySerialNumber(report.getSerialNumber()).orElseThrow();
        return repo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repo.findAll();
    }
}
