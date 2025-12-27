package com.example.demo.service.impl;

import com.example.demo.model.PricingRule;
import com.example.demo.repository.PricingRuleRepository;
import com.example.demo.service.PricingRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PricingRuleServiceImpl implements PricingRuleService {

    @Autowired
    private PricingRuleRepository pricingRuleRepository;

    @Override
    public PricingRule createRule(PricingRule rule) {
        return pricingRuleRepository.save(rule);
    }

    @Override
    public PricingRule getRuleById(Long id) {
        return pricingRuleRepository.findById(id).orElse(null);
    }

    @Override
    public List<PricingRule> getAllRules() {
        return pricingRuleRepository.findAll();
    }

    @Override
    public PricingRule updateRule(Long id, PricingRule rule) {
        Optional<PricingRule> optional = pricingRuleRepository.findById(id);
        if (optional.isPresent()) {
            PricingRule existing = optional.get();
            existing.setRuleName(rule.getRuleName());
            existing.setMultiplier(rule.getMultiplier());
            return pricingRuleRepository.save(existing);
        }
        return null;
    }
}
