package com.example.demo.service;

/**
 * Interface for sending fraud alerts.
 */
public interface FraudAlertService {

    /**
     * Sends a fraud alert with the given message.
     *
     * @param message The message describing the fraud alert.
     */
    void sendAlert(String message);
}
