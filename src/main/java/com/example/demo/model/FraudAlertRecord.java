package com.example.demo.model;

public class FraudAlertRecord {

    private Long id;
    private boolean resolved;

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
