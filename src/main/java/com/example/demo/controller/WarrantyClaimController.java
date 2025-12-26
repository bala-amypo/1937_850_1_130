package com.example.demo.controller;

import com.example.demo.service.impl.WarrantyClaimServiceImpl;

public class WarrantyClaimController {

    private final WarrantyClaimServiceImpl service;

    public WarrantyClaimController(WarrantyClaimServiceImpl service) {
        this.service = service;
    }
}
