package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.impl.DeviceOwnershipServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipServiceImpl deviceService;

    public DeviceOwnershipController(DeviceOwnershipServiceImpl deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/register")
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord record) {
        return deviceService.registerDevice(record);
    }

    @GetMapping("/{serialNumber}")
    public Optional<DeviceOwnershipRecord> getDevice(@PathVariable String serialNumber) {
        return deviceService.getBySerial(serialNumber);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return deviceService.updateDeviceStatus(id, active);
    }
}
