package com.example.demo.serviceimpl;

import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    @Override
    public void sendAlert(String message) {
        // For now, just print the alert. You can extend this to send emails or notifications.
        System.out.println("FRAUD ALERT: " + message);
    }
}
