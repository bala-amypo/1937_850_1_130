package com.example.demo.serviceimpl;

import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    @Override
    public void sendAlert(String message) {
        System.out.println("FRAUD ALERT: " + message);
    }
}
