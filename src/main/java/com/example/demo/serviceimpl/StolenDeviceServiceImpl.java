package com.example.demo.serviceimpl;

import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    @Override
    public void reportStolenDevice(String deviceSerial) {
        // Example implementation: log the device
        System.out.println("Stolen device reported: " + deviceSerial);
    }
}
