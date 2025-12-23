package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;         // <-- ensure this exists
    private String serialNumber;  // <-- ensure this exists

    private String description;

    // other fields...
}
