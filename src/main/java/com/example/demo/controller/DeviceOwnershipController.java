package com.example.demo.controller;

import com.example.demo.service.impl.DeviceOwnershipServiceImpl;

public class DeviceOwnershipController {

    private final DeviceOwnershipServiceImpl service;

    public DeviceOwnershipController(DeviceOwnershipServiceImpl service) {
        this.service = service;
    }
}
