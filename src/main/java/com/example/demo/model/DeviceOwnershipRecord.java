package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "serialNumber"))
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String serialNumber;

    @NotBlank
    private String ownerName;

    @Email
    private String ownerEmail;

    @NotNull
    private LocalDate purchaseDate;

    @NotNull
    private LocalDate warrantyExpiration;

    private Boolean active = true;

    
}