package com.example.demo.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class WarrantyClaimRecord {

    private Long id;
    private String serialNumber;
    private String claimReason;
    private String status = "PENDING";
    private LocalDateTime createdAt = LocalDateTime.now();
}
