package com.example.demo.repository;

import com.example.demo.model.PricingRule;
import java.util.List;

public interface PricingRuleRepository {
    boolean existsByRuleCode(String code);
    List<PricingRule> findAll();
    List<PricingRule> findByActiveTrue();
    PricingRule save(PricingRule rule);
}
