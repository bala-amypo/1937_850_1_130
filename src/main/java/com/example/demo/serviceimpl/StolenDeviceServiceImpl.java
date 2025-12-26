package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.util.*;

public class StolenDeviceServiceImpl {

    private final StolenDeviceReportRepository repo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository r, DeviceOwnershipRecordRepository d) {
        repo = r; deviceRepo = d;
    }

    public StolenDeviceReport reportStolen(StolenDeviceReport r) {
        deviceRepo.findBySerialNumber(r.getSerialNumber()).orElseThrow();
        return repo.save(r);
    }

    public List<StolenDeviceReport> getReportsBySerial(String s) {
        return repo.findBySerialNumber(s);
    }

    public List<StolenDeviceReport> getAllReports() {
        return repo.findAll();
    }
}
