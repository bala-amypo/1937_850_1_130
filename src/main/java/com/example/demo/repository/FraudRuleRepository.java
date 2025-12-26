public interface FraudRuleRepository {
    Optional<FraudRule> findByRuleCode(String c);
    List<FraudRule> findByActiveTrue();
    FraudRule save(FraudRule r);
}
