package com.example.demo.service.impl;

import com.example.demo.model.PricingRule;
import com.example.demo.repository.PricingRuleRepository;
import com.example.demo.service.PricingRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingRuleServiceImpl implements PricingRuleService {

    private final PricingRuleRepository repository;

    public PricingRuleServiceImpl(PricingRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PricingRule createRule(PricingRule rule) {
        return repository.save(rule);
    }

    @Override
    public PricingRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PricingRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<PricingRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public PricingRule updateRule(Long id, PricingRule updatedRule) {
        PricingRule existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setRuleName(updatedRule.getRuleName());
        existing.setMultiplier(updatedRule.getMultiplier());
        existing.setActive(updatedRule.isActive());

        return repository.save(existing);
    }
}
