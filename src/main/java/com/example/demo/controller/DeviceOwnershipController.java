package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Ownership")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceService;

    public DeviceOwnershipController(DeviceOwnershipService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord device) {
        return deviceService.registerDevice(device);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        deviceService.updateDeviceStatus(id, active);
    }

    @GetMapping("/serial/{serialNumber}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serialNumber) {
        return deviceService.getBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public DeviceOwnershipRecord getById(@PathVariable Long id) {
        return deviceService.getById(id);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return deviceService.getAllDevices();
    }
}
