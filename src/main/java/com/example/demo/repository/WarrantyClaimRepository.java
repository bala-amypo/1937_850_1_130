public interface WarrantyClaimRecordRepository {
    boolean existsBySerialNumberAndClaimReason(String s, String r);
    Optional<WarrantyClaimRecord> findById(Long id);
    List<WarrantyClaimRecord> findAll();
    List<WarrantyClaimRecord> findBySerialNumber(String s);
    WarrantyClaimRecord save(WarrantyClaimRecord c);
}
