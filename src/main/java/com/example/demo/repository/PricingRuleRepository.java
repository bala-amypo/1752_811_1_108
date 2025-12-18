public interface PricingRuleRepository extends
JpaRepository<PricingRule, Long>{
    boolean existsByRuleCode(String ruleCode);
    List<PricingRule> findByEventId(Long eventId);
}