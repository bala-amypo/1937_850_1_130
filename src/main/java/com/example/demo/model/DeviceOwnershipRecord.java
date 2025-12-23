// DeviceOwnershipRecord.java
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class DeviceOwnershipRecord {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private Long userId;
    private LocalDateTime ownershipDate;
}

// WarrantyClaimRecord.java
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class WarrantyClaimRecord {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private Long claimId;
    private String status;
}
