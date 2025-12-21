package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleCode;

    private String description;
    private String ruleType;
    private Boolean active;

    public String getRuleCode() {
        return ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public String getRuleType() {
        return ruleType;
    }

    public Boolean getActive() {
        return active;
    }
}
