package com.example.demo.model;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class FraudAlertRecord {
    private Long id;
    private Long claimId;
    private String serialNumber;
    private Boolean resolved = false;
}
