package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;

import java.util.List;
import java.util.NoSuchElementException;

public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;

    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository stolenRepository,
            DeviceOwnershipRecordRepository deviceRepository) {

        this.stolenRepository = stolenRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        if (!deviceRepository.existsBySerialNumber(report.getSerialNumber())) {
            throw new NoSuchElementException("Device not found");
        }
        return stolenRepository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return stolenRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public StolenDeviceReport getReportById(Long id) {
        return stolenRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Report not found"));
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepository.findAll();
    }
}
