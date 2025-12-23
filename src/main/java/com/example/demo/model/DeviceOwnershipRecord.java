package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "device_ownership_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerEmail;

    @Column(nullable = false)
    private String ownershipDate;

}
