package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

public interface EventRecordRepository extends JpaRepository<EventRecord, Long> {}
public interface SeatInventoryRecordRepository extends JpaRepository<SeatInventoryRecord, Long> {}
public interface PricingRuleRepository extends JpaRepository<PricingRule, Long> {}
public interface DynamicPriceRecordRepository extends JpaRepository<DynamicPriceRecord, Long> {}
public interface PriceAdjustmentLogRepository extends JpaRepository<PriceAdjustmentLog, Long> {}
