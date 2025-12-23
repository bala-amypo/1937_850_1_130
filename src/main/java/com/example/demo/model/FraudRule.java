package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "fraud_rule",
        uniqueConstraints = @UniqueConstraint(columnNames = "ruleCode")
)
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    private String description;

    private String ruleType;

    private Boolean active;

    public FraudRule() {
    }

    // getters and setters
}
