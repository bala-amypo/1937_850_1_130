package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService service;

    @PostMapping("/register")
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord record) {
        return service.registerDevice(record);
    }

    @PutMapping("/{id}/status")
    public void updateDeviceStatus(@PathVariable Long id, @RequestParam boolean stolen) {
        service.updateDeviceStatus(id, stolen);
    }

    @GetMapping("/serial/{serialNumber}")
    public DeviceOwnershipRecord getDeviceBySerial(@PathVariable String serialNumber) {
        Optional<DeviceOwnershipRecord> optionalRecord = service.getBySerial(serialNumber);
        return optionalRecord.orElse(null); // or throw an exception if preferred
    }

    @GetMapping("/all")
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }
}
