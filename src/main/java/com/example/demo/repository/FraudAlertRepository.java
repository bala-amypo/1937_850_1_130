public interface FraudAlertRecordRepository {
    Optional<FraudAlertRecord> findById(Long id);
    List<FraudAlertRecord> findByClaimId(Long id);
    FraudAlertRecord save(FraudAlertRecord a);
}
