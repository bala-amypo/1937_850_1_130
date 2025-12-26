package com.example.demo.controller;

import com.example.demo.service.impl.StolenDeviceServiceImpl;

public class StolenDeviceController {

    private final StolenDeviceServiceImpl service;

    public StolenDeviceController(StolenDeviceServiceImpl service) {
        this.service = service;
    }
}
