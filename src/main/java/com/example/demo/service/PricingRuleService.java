package com.example.demo.service;

import com.example.demo.model.PricingRule;
import java.util.List;

public interface PricingRuleService {
    PricingRule createRule(PricingRule rule);
    PricingRule getRuleById(Long id);
    List<PricingRule> getAllRules();
    PricingRule updateRule(Long id, PricingRule rule);
}
