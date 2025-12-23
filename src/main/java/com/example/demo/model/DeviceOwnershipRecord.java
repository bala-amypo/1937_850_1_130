package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "device_ownership_record",
        uniqueConstraints = @UniqueConstraint(columnNames = "serialNumber")
)
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    private String ownerName;

    private String ownerEmail;

    private LocalDate purchaseDate;

    private LocalDate warrantyExpiration;

    private Boolean active;

    public DeviceOwnershipRecord() {
    }

    // getters and setters
}
