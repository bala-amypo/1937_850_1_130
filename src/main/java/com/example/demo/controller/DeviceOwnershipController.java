package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService deviceService;

    @PutMapping("/{id}/stolen")
    public DeviceOwnershipRecord markAsStolen(@PathVariable Long id, @RequestParam boolean stolen) {
        return deviceService.updateDeviceStatus(id, stolen);
    }
}
