package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService deviceService;

    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateDeviceStatus(@PathVariable Long id, @RequestParam boolean stolen) {
        return deviceService.updateDeviceStatus(id, stolen);
    }
}
