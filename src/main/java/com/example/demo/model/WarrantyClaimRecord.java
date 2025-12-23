package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyClaimRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private String serialNumber;

    private String issueDescription;

    private LocalDateTime claimDate;
}
