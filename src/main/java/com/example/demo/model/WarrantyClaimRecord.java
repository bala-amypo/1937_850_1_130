package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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
    private String claimId;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private LocalDateTime claimDate;

    @Column(nullable = false)
    private boolean approved;

    // You can add more fields as needed
}
