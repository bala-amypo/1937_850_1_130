package com.example.demo.model;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class StolenDeviceReport {
    private Long id;
    private String serialNumber;
}
