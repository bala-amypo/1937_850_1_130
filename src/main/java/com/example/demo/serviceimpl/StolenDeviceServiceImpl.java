package com.example.demo.serviceimpl;

import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    @Override
    public void reportStolenDevice(String serialNumber) {
        System.out.println("Device reported stolen: " + serialNumber);
    }
}
