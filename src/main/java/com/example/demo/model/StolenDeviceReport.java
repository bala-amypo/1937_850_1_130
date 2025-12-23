package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stolen_device_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String reportedBy;

    @Column(nullable = false)
    private String reportDate;

}
