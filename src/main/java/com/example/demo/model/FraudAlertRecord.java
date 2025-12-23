package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fraud_alert_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String alertDate;

}
