package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "warranty_claim_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String claimReason;

    @Column(nullable = false)
    private String claimDate;

    @Column(nullable = false)
    private Boolean isFraudulent;

}
